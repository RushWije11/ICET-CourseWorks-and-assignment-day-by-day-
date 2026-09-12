import org.joml.Matrix4f;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;

public class UniverseSimulation {
    private long window;
    private int width = 1920, height = 1080;
    private PhysicsEngine physics;
    private Renderer renderer;
    private Camera camera;
    private CharacterController character;
    private boolean running = true;
    private boolean paused = false;
    private double lastTime;
    private CelestialBody selectedBody;
    private boolean bigBangTriggered = false;

    public void run() {
        init();
        loop();
        cleanup();
    }

    private void init() {
        GLFWErrorCallback.createPrint(System.err).set();
        if (!GLFW.glfwInit()) throw new RuntimeException("Failed to init GLFW");

        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 3);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);

        window = GLFW.glfwCreateWindow(width, height, "Universe Simulation Engine - Big Bang to Civilization", MemoryUtil.NULL, MemoryUtil.NULL);
        if (window == MemoryUtil.NULL) throw new RuntimeException("Failed to create window");

        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwSwapInterval(1);
        GLFW.glfwShowWindow(window);
        GLFW.glfwSetInputMode(window, GLFW.GLFW_CURSOR, GLFW.GLFW_CURSOR_NORMAL);

        GL.createCapabilities();

        physics = new PhysicsEngine();
        renderer = new Renderer();
        renderer.init();
        camera = new Camera();
        character = new CharacterController();

        System.out.println("=== UNIVERSE SIMULATION ENGINE ===");
        System.out.println("Singularity initialized. Press SPACE for Big Bang.");
        System.out.println("Controls: WASD = Move, Q/E = Zoom, RMB = Orbit/Look");
        System.out.println("F = Free camera, C = Click planet to spawn character");
        System.out.println("Click on a body to inspect. ESC = Exit character mode");

        GLFW.glfwSetMouseButtonCallback(window, this::onMouseClick);
        GLFW.glfwSetScrollCallback(window, (win, x, y) -> camera.setFreeMode(true));
    }

    private void onMouseClick(long win, int button, int action, int mods) {
        if (button == GLFW.GLFW_MOUSE_BUTTON_LEFT && action == GLFW.GLFW_PRESS && !camera.isCharacterMode()) {
            double[] mx = new double[1], my = new double[1];
            GLFW.glfwGetCursorPos(win, mx, my);
            selectedBody = pickBody(mx[0], my[0]);
            if (selectedBody != null) {
                System.out.println("Selected: " + selectedBody.getName() + " [" + selectedBody.getType() + "]");
                System.out.println("  Mass: " + String.format("%.2f", selectedBody.getMass()));
                System.out.println("  Temp: " + String.format("%.1f", selectedBody.getTemperature()) + " K");
                if (selectedBody.hasLife()) {
                    LifeForm l = selectedBody.getLifeForm();
                    System.out.println("  LIFE DETECTED: " + l.getDominantSpecies());
                    System.out.println("  Complexity: " + l.getComplexity());
                    System.out.println("  Population: " + String.format("%.2e", l.getPopulation()));
                }
                camera.focusOn(selectedBody);
            }
        }
    }

    private CelestialBody pickBody(double mx, double my) {
        CelestialBody closest = null;
        double minZ = Double.MAX_VALUE;
        for (CelestialBody b : physics.getAllBodies()) {
            if (!b.isAlive()) continue;
            Vector3d pos = b.getPosition();
            double dist = pos.distance(camera.getPosition());
            if (dist < b.getRadius() * 3 + 10) {
                if (closest == null || dist < minZ) { closest = b; minZ = dist; }
            }
        }
        return closest;
    }

    private void loop() {
        lastTime = GLFW.glfwGetTime();
        while (running && !GLFW.glfwWindowShouldClose(window)) {
            double currentTime = GLFW.glfwGetTime();
            double dt = Math.min(currentTime - lastTime, 0.05);
            lastTime = currentTime;

            processInput(dt);
            if (!paused && bigBangTriggered) {
                physics.update(Constants.TIME_STEP);
                evolveLife();
            }
            if (camera.getFocusedBody() != null && !camera.isCharacterMode() && !camera.isFreeMode()) {
                camera.focusOn(camera.getFocusedBody());
            }
            renderer.render(physics.getAllBodies(), camera, width, height);
            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();
        }
    }

    private void evolveLife() {
        for (CelestialBody b : physics.getAllBodies()) {
            if (b.isPlanet() && b.hasLife()) {
                b.getLifeForm().evolve(Constants.TIME_STEP, 1.0);
            }
        }
    }

    private void processInput(double dt) {
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_ESCAPE) == GLFW.GLFW_PRESS) {
            if (camera.isCharacterMode()) camera.exitCharacterMode();
            else running = false;
        }
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_SPACE) == GLFW.GLFW_PRESS && !bigBangTriggered) {
            bigBangTriggered = true;
            physics.bigBang(Constants.MAX_PARTICLES, 25.0);
            System.out.println(">>> BIG BANG EVENT TRIGGERED <<<");
            System.out.println("Spawning " + Constants.MAX_PARTICLES + " mass particles...");
        }
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_P) == GLFW.GLFW_PRESS) paused = !paused;
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_F) == GLFW.GLFW_PRESS) camera.setFreeMode(true);
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_C) == GLFW.GLFW_PRESS) {
            if (selectedBody != null && selectedBody.isPlanet()) {
                Vector3d surface = new Vector3d(selectedBody.getPosition()).add(selectedBody.getRadius() + 2, 0, 0);
                camera.enterCharacterMode(selectedBody, surface);
                character.spawnOnPlanet(selectedBody, 0, 0);
                System.out.println(">>> TRANSITIONING TO PLANET SURFACE <<<");
                System.out.println("You are now walking on " + selectedBody.getName());
            }
        }
        camera.update(dt, window);
    }

    private void cleanup() {
        renderer.cleanup();
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
        GLFW.glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new UniverseSimulation().run();
    }
}

class Constants {
    private Constants() {}
    public static final double G = 6.674e-11;
    public static final double C = 299792458.0;
    public static final double SOLAR_MASS = 1.989e30;
    public static final double EARTH_MASS = 5.972e24;
    public static final double AU = 1.496e11;
    public static final double LIGHT_YEAR = 9.461e15;
    public static final double SIM_G = 0.5;
    public static final double ACCRETION_THRESHOLD = 2.5;
    public static final double MERGE_DISTANCE_FACTOR = 0.08;
    public static final double STAR_FORMATION_MASS = 80.0;
    public static final double BLACK_HOLE_MASS = 3000.0;
    public static final double GALAXY_FORMATION_MASS = 50000.0;
    public static final double MIN_PLANET_MASS = 0.5;
    public static final double MAX_PLANET_MASS = 20.0;
    public static final double HABITABLE_INNER = 15.0;
    public static final double HABITABLE_OUTER = 35.0;
    public static final double TIME_STEP = 0.016;
    public static final int MAX_PARTICLES = 15000;
    public static final double SOFTENING = 2.0;
    public static final double DARK_ENERGY_FACTOR = 0.00001;
    public static final double SCHWARZSCHILD_FACTOR = 2.0 * G / (C * C);
}

class SeededRandom {
    private static final ThreadLocal<Random> RANDOM = ThreadLocal.withInitial(Random::new);
    private long seed;
    public SeededRandom(long seed) {
        this.seed = seed;
        RANDOM.get().setSeed(seed);
    }
    public double nextDouble() { return RANDOM.get().nextDouble(); }
    public double nextDouble(double min, double max) { return min + RANDOM.get().nextDouble() * (max - min); }
    public float nextFloat() { return RANDOM.get().nextFloat(); }
    public float nextFloat(float min, float max) { return min + RANDOM.get().nextFloat() * (max - min); }
    public int nextInt(int bound) { return RANDOM.get().nextInt(bound); }
    public int nextInt(int min, int max) { return min + RANDOM.get().nextInt(max - min); }
    public boolean nextBoolean() { return RANDOM.get().nextBoolean(); }
    public double nextGaussian() { return RANDOM.get().nextGaussian(); }
    public void reseed() { RANDOM.get().setSeed(seed); }
}

abstract class CelestialBody {
    protected final UUID id;
    protected Vector3d position;
    protected Vector3d velocity;
    protected Vector3d acceleration;
    protected double mass;
    protected double radius;
    protected double temperature;
    protected double age;
    protected double luminosity;
    protected String name;
    protected CelestialBody parent;
    protected final List<CelestialBody> children;
    protected boolean alive;
    protected BodyType type;
    protected double rotationAngle;
    protected double rotationSpeed;
    protected double orbitalPeriod;
    protected double semiMajorAxis;
    protected double eccentricity;
    protected double inclination;
    protected Vector3f color;
    protected double density;
    protected boolean hasAtmosphere;
    protected double atmosphereThickness;
    protected Vector3f atmosphereColor;
    protected boolean isHabitable;
    protected boolean hasLife;
    protected LifeForm lifeForm;

    public enum BodyType {
        SINGULARITY, PARTICLE, DUST, GAS, PROTOSTAR, STAR, PLANET, MOON,
        ASTEROID, COMET, BLACK_HOLE, NEUTRON_STAR, WHITE_DWARF, RED_GIANT,
        SUPERNOVA_REMNANT, GALAXY_CORE, DARK_MATTER
    }

    public CelestialBody(Vector3d pos, Vector3d vel, double mass, BodyType type) {
        this.id = UUID.randomUUID();
        this.position = new Vector3d(pos);
        this.velocity = new Vector3d(vel);
        this.acceleration = new Vector3d(0);
        this.mass = mass;
        this.type = type;
        this.children = new ArrayList<>();
        this.alive = true;
        this.age = 0;
        this.temperature = 0;
        this.luminosity = 0;
        this.rotationAngle = 0;
        this.rotationSpeed = 0;
        this.color = new Vector3f(1,1,1);
        this.density = 1.0;
        this.hasAtmosphere = false;
        this.isHabitable = false;
        this.hasLife = false;
        updateRadius();
    }

    public void update(double dt) {
        if (!alive) return;
        velocity.add(acceleration.x * dt, acceleration.y * dt, acceleration.z * dt);
        position.add(velocity.x * dt, velocity.y * dt, velocity.z * dt);
        acceleration.set(0, 0, 0);
        age += dt;
        rotationAngle += rotationSpeed * dt;
        for (CelestialBody child : children) child.update(dt);
    }

    public void applyForce(Vector3d force) {
        if (mass > 0) acceleration.add(force.x / mass, force.y / mass, force.z / mass);
    }

    public double distanceTo(CelestialBody other) { return position.distance(other.position); }
    public double distanceTo(Vector3d point) { return position.distance(point); }

    public void addChild(CelestialBody child) { child.parent = this; children.add(child); }
    public void removeChild(CelestialBody child) { children.remove(child); child.parent = null; }

    public void mergeWith(CelestialBody other) {
        double totalMass = mass + other.mass;
        Vector3d newVel = new Vector3d(velocity).mul(mass).add(new Vector3d(other.velocity).mul(other.mass)).div(totalMass);
        velocity.set(newVel);
        position.set(position.mul(mass).add(other.position.mul(other.mass)).div(totalMass));
        mass = totalMass;
        updateRadius();
        other.alive = false;
        for (CelestialBody child : other.children) addChild(child);
    }

    protected void updateRadius() {
        switch (type) {
            case STAR, PROTOSTAR, RED_GIANT -> radius = Math.pow(mass, 0.8) * 2.0;
            case BLACK_HOLE -> radius = Math.max(2.0, mass * 0.05);
            case PLANET, MOON -> radius = Math.pow(mass / density, 0.333) * 1.5;
            case GALAXY_CORE -> radius = Math.pow(mass, 0.4) * 5.0;
            default -> radius = Math.pow(mass, 0.333);
        }
    }

    public double getSchwarzschildRadius() { return 2.0 * Constants.G * mass / (Constants.C * Constants.C); }
    public boolean isBlackHole() { return type == BodyType.BLACK_HOLE || (type == BodyType.STAR && mass > Constants.BLACK_HOLE_MASS); }
    public boolean isStar() { return type == BodyType.STAR || type == BodyType.PROTOSTAR || type == BodyType.RED_GIANT; }
    public boolean isPlanet() { return type == BodyType.PLANET || type == BodyType.MOON; }

    public Vector3d getPosition() { return position; }
    public Vector3d getVelocity() { return velocity; }
    public double getMass() { return mass; }
    public double getRadius() { return radius; }
    public BodyType getType() { return type; }
    public boolean isAlive() { return alive; }
    public List<CelestialBody> getChildren() { return children; }
    public UUID getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getTemperature() { return temperature; }
    public double getLuminosity() { return luminosity; }
    public Vector3f getColor() { return color; }
    public boolean isHabitable() { return isHabitable; }
    public boolean hasLife() { return hasLife; }
    public LifeForm getLifeForm() { return lifeForm; }
    public void setLifeForm(LifeForm life) { this.lifeForm = life; this.hasLife = true; }
    public void setHabitable(boolean h) { this.isHabitable = h; }
    public void setColor(float r, float g, float b) { color.set(r,g,b); }
    public void setTemperature(double t) { temperature = t; }
    public void setLuminosity(double l) { luminosity = l; }
    public double getSemiMajorAxis() { return semiMajorAxis; }
    public void setSemiMajorAxis(double a) { semiMajorAxis = a; }
    public double getEccentricity() { return eccentricity; }
    public void setEccentricity(double e) { eccentricity = e; }
    public double getInclination() { return inclination; }
    public void setInclination(double i) { inclination = i; }
    public double getRotationAngle() { return rotationAngle; }
    public double getRotationSpeed() { return rotationSpeed; }
    public void setRotationSpeed(double s) { rotationSpeed = s; }
    public boolean hasAtmosphere() { return hasAtmosphere; }
    public void setHasAtmosphere(boolean a) { hasAtmosphere = a; }
    public double getAtmosphereThickness() { return atmosphereThickness; }
    public void setAtmosphereThickness(double t) { atmosphereThickness = t; }
    public Vector3f getAtmosphereColor() { return atmosphereColor; }
    public void setAtmosphereColor(Vector3f c) { atmosphereColor = c; }
    public void setDensity(double d) { density = d; updateRadius(); }
    public double getDensity() { return density; }
    public void setParent(CelestialBody p) { this.parent = p; }
}

class Particle extends CelestialBody {
    private double originalMass;
    private int accretionCount;
    private double metallicity;

    public Particle(Vector3d pos, Vector3d vel, double mass) {
        super(pos, vel, mass, BodyType.PARTICLE);
        this.originalMass = mass;
        this.accretionCount = 0;
        this.metallicity = Math.random() * 0.05;
        updateAppearance();
    }

    public void updateAppearance() {
        if (mass < 1.0) {
            type = BodyType.DUST;
            setColor(0.6f, 0.5f, 0.4f);
        } else if (mass < Constants.STAR_FORMATION_MASS * 0.1) {
            type = BodyType.GAS;
            setColor(0.8f, 0.7f, 0.9f);
            setTemperature(50 + mass * 2);
        } else if (mass < Constants.STAR_FORMATION_MASS) {
            type = BodyType.PROTOSTAR;
            setColor(1.0f, 0.6f, 0.3f);
            setTemperature(1000 + mass * 50);
            setLuminosity(mass * mass * 0.001);
        } else if (mass < Constants.BLACK_HOLE_MASS) {
            type = BodyType.STAR;
            setColor(1.0f, 0.9f, 0.7f);
            setTemperature(3000 + Math.min(mass * 30, 25000));
            setLuminosity(Math.pow(mass, 3.5) * 0.01);
            setRotationSpeed(0.001 + Math.random() * 0.01);
        } else if (mass < Constants.GALAXY_FORMATION_MASS) {
            type = BodyType.BLACK_HOLE;
            setColor(0.0f, 0.0f, 0.0f);
            setTemperature(0);
            setLuminosity(0);
            setRotationSpeed(0.1);
        } else {
            type = BodyType.GALAXY_CORE;
            setColor(1.0f, 0.8f, 0.5f);
            setTemperature(100000);
            setLuminosity(mass * 100);
            setRotationSpeed(0.05);
        }
        updateRadius();
    }

    public void accrete(double addedMass) {
        mass += addedMass;
        accretionCount++;
        metallicity += 0.001;
        updateAppearance();
    }

    public double getMetallicity() { return metallicity; }
    public int getAccretionCount() { return accretionCount; }
    public double getOriginalMass() { return originalMass; }
}

class Planet extends CelestialBody {
    private double waterCoverage;
    private double vegetationCoverage;
    private double iceCoverage;
    private double surfaceGravity;
    private int numMoons;
    private double dayLength;
    private double yearLength;
    private boolean ringSystem;

    public Planet(Vector3d pos, Vector3d vel, double mass, double density) {
        super(pos, vel, mass, BodyType.PLANET);
        setDensity(density);
        this.surfaceGravity = mass / (radius * radius);
        this.dayLength = 10 + Math.random() * 40;
        this.yearLength = 100 + Math.random() * 1000;
        this.ringSystem = Math.random() < 0.15;
        updateHabitability();
    }

    public void updateHabitability() {
        if (parent != null && parent.isStar()) {
            double dist = distanceTo(parent);
            double starLum = parent.getLuminosity();
            double effectiveDist = dist / Math.sqrt(starLum + 1);
            isHabitable = (effectiveDist >= Constants.HABITABLE_INNER && effectiveDist <= Constants.HABITABLE_OUTER)
                    && mass >= Constants.MIN_PLANET_MASS && mass <= Constants.MAX_PLANET_MASS * 3
                    && hasAtmosphere && temperature > 200 && temperature < 350;
            if (isHabitable) {
                waterCoverage = Math.random() * 0.8 + 0.1;
                vegetationCoverage = Math.random() * 0.6;
                iceCoverage = temperature < 273 ? Math.random() * 0.3 : 0;
                setColor(0.2f + (float)(waterCoverage * 0.3), 0.4f + (float)(vegetationCoverage * 0.4), 0.3f + (float)(waterCoverage * 0.3));
            } else if (temperature > 400) {
                setColor(0.8f, 0.3f, 0.1f);
                waterCoverage = 0;
            } else if (temperature < 150) {
                setColor(0.9f, 0.9f, 1.0f);
                iceCoverage = 0.9;
            } else {
                setColor(0.6f, 0.5f, 0.4f);
            }
        }
    }

    public double getWaterCoverage() { return waterCoverage; }
    public double getVegetationCoverage() { return vegetationCoverage; }
    public double getSurfaceGravity() { return surfaceGravity; }
    public int getNumMoons() { return numMoons; }
    public void setNumMoons(int n) { numMoons = n; }
    public boolean hasRingSystem() { return ringSystem; }
}

class Star extends CelestialBody {
    private double spectralClass;
    private double lifespan;
    private double ageBillionYears;
    private boolean isMainSequence;

    public Star(Vector3d pos, Vector3d vel, double mass) {
        super(pos, vel, mass, BodyType.STAR);
        this.isMainSequence = true;
        calculateStellarProperties();
    }

    private void calculateStellarProperties() {
        spectralClass = Math.max(0, Math.min(7, 7 - (mass / 100.0)));
        lifespan = 1e4 / (mass * mass * mass + 1);
        setLuminosity(Math.pow(mass, 3.5) * 0.01);
        setTemperature(3000 + Math.min(mass * 30, 40000));
        ageBillionYears = 0;

        float r, g, b;
        double t = temperature;
        if (t > 30000) { r=0.6f; g=0.7f; b=1.0f; }
        else if (t > 10000) { r=0.8f; g=0.9f; b=1.0f; }
        else if (t > 7500) { r=1.0f; g=1.0f; b=1.0f; }
        else if (t > 6000) { r=1.0f; g=1.0f; b=0.9f; }
        else if (t > 5000) { r=1.0f; g=0.95f; b=0.7f; }
        else if (t > 3500) { r=1.0f; g=0.7f; b=0.3f; }
        else { r=1.0f; g=0.4f; b=0.2f; }
        setColor(r, g, b);
        setRotationSpeed(0.001 + Math.random() * 0.01);
    }

    public void evolve(double dt) {
        ageBillionYears += dt * 0.0001;
        if (ageBillionYears > lifespan && isMainSequence) {
            if (mass > Constants.BLACK_HOLE_MASS * 0.3) {
                type = BodyType.BLACK_HOLE; setColor(0,0,0); setTemperature(0); setLuminosity(0);
            } else if (mass > 20) {
                type = BodyType.NEUTRON_STAR; setColor(0.9f, 0.9f, 1.0f); setTemperature(1000000); setLuminosity(0.1);
            } else {
                type = BodyType.WHITE_DWARF; setColor(1.0f, 1.0f, 1.0f); setTemperature(50000); setLuminosity(0.01);
            }
            isMainSequence = false;
        }
    }

    public double getSpectralClass() { return spectralClass; }
    public double getHabitableZoneInner() { return Math.sqrt(luminosity) * Constants.HABITABLE_INNER; }
    public double getHabitableZoneOuter() { return Math.sqrt(luminosity) * Constants.HABITABLE_OUTER; }
}

class BlackHole extends CelestialBody {
    private double eventHorizonRadius;
    private double accretionDiskTemp;
    private double spin;

    public BlackHole(Vector3d pos, Vector3d vel, double mass) {
        super(pos, vel, mass, BodyType.BLACK_HOLE);
        this.eventHorizonRadius = (2.0 * Constants.G * mass) / (Constants.C * Constants.C);
        this.accretionDiskTemp = mass * 10;
        this.spin = Math.random();
        setColor(0.0f, 0.0f, 0.0f);
        setRotationSpeed(0.1 + spin * 0.9);
    }

    public double getEventHorizonRadius() { return eventHorizonRadius; }
    public double getAccretionDiskTemp() { return accretionDiskTemp; }
    public double getSpin() { return spin; }
}

class LifeForm {
    public enum Complexity { SINGLE_CELL, MULTI_CELL, PLANT, ANIMAL, SENTIENT, CIVILIZATION }

    private Complexity complexity;
    private double evolutionProgress;
    private double population;
    private double biodiversity;
    private double techLevel;
    private double age;
    private String dominantSpecies;
    private boolean isSpacefaring;

    public LifeForm() {
        this.complexity = Complexity.SINGLE_CELL;
        this.evolutionProgress = 0;
        this.population = 1e6;
        this.biodiversity = Math.random();
        this.techLevel = 0;
        this.age = 0;
        this.dominantSpecies = "Protobacteria";
        this.isSpacefaring = false;
    }

    public void evolve(double dt, double planetStability) {
        age += dt;
        double evolutionRate = dt * 0.001 * planetStability;
        evolutionProgress += evolutionRate;

        if (complexity == Complexity.SINGLE_CELL && evolutionProgress > 0.1) {
            complexity = Complexity.MULTI_CELL;
            dominantSpecies = "Metazoa";
            population *= 100;
        } else if (complexity == Complexity.MULTI_CELL && evolutionProgress > 0.3) {
            complexity = Complexity.PLANT;
            dominantSpecies = "Flora";
            population *= 1000;
        } else if (complexity == Complexity.PLANT && evolutionProgress > 0.4) {
            complexity = Complexity.ANIMAL;
            dominantSpecies = "Fauna";
            population *= 100;
        } else if (complexity == Complexity.ANIMAL && evolutionProgress > 0.7) {
            complexity = Complexity.SENTIENT;
            dominantSpecies = "Sentient_" + (int)(Math.random()*10000);
            population = Math.min(population, 1e9);
        } else if (complexity == Complexity.SENTIENT && evolutionProgress > 0.9) {
            complexity = Complexity.CIVILIZATION;
            techLevel += dt * 0.01;
            if (techLevel > 0.8) isSpacefaring = true;
        }

        if (complexity.ordinal() >= Complexity.ANIMAL.ordinal()) {
            population += population * 0.001 * dt;
        }
    }

    public Complexity getComplexity() { return complexity; }
    public double getPopulation() { return population; }
    public double getTechLevel() { return techLevel; }
    public boolean isSpacefaring() { return isSpacefaring; }
    public String getDominantSpecies() { return dominantSpecies; }
    public double getEvolutionProgress() { return evolutionProgress; }
}

class PhysicsEngine {
    private final List<Particle> particles;
    private final List<CelestialBody> bodies;
    private final ExecutorService executor;
    private final double theta = 0.5;
    private double simulationTime = 0;
    private int frameCount = 0;

    public PhysicsEngine() {
        this.particles = new ArrayList<>();
        this.bodies = new ArrayList<>();
        this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void addParticle(Particle p) { particles.add(p); }
    public List<Particle> getParticles() { return particles; }
    public List<CelestialBody> getAllBodies() {
        List<CelestialBody> all = new ArrayList<>(bodies);
        all.addAll(particles);
        return all;
    }

    public void bigBang(int count, double energy) {
        particles.clear();
        bodies.clear();
        Random rand = new Random(42);
        for (int i = 0; i < count; i++) {
            double theta = rand.nextDouble() * Math.PI * 2;
            double phi = Math.acos(2 * rand.nextDouble() - 1);
            double speed = energy * (0.5 + rand.nextDouble() * 0.5);
            double vx = speed * Math.sin(phi) * Math.cos(theta);
            double vy = speed * Math.sin(phi) * Math.sin(theta);
            double vz = speed * Math.cos(phi);
            double mass = 0.1 + rand.nextDouble() * 2.0;
            Particle p = new Particle(new Vector3d(0,0,0), new Vector3d(vx,vy,vz), mass);
            particles.add(p);
        }
    }

    public void update(double dt) {
        simulationTime += dt;
        frameCount++;

        Octree tree = new Octree(new Vector3d(-1e6, -1e6, -1e6), new Vector3d(1e6, 1e6, 1e6));
        for (Particle p : particles) if (p.isAlive()) tree.insert(p);

        int threads = Runtime.getRuntime().availableProcessors();
        int chunk = Math.max(1, particles.size() / threads);
        List<Future<?>> futures = new ArrayList<>();
        for (int t = 0; t < threads; t++) {
            final int start = t * chunk;
            final int end = (t == threads - 1) ? particles.size() : (t + 1) * chunk;
            futures.add(executor.submit(() -> {
                for (int i = start; i < end; i++) {
                    Particle p = particles.get(i);
                    if (!p.isAlive()) continue;
                    Vector3d force = tree.calculateForce(p, theta);
                    p.applyForce(force);
                }
            }));
        }
        for (Future<?> f : futures) {
            try { f.get(); } catch (Exception e) { e.printStackTrace(); }
        }

        List<Particle> toRemove = new ArrayList<>();
        for (int i = 0; i < particles.size(); i++) {
            Particle a = particles.get(i);
            if (!a.isAlive()) continue;
            a.update(dt);

            for (int j = i + 1; j < particles.size(); j++) {
                Particle b = particles.get(j);
                if (!b.isAlive()) continue;
                double dist = a.distanceTo(b);
                double mergeDist = (a.getRadius() + b.getRadius()) * Constants.MERGE_DISTANCE_FACTOR * 5;
                if (dist < mergeDist && dist > 0.1) {
                    if (a.getMass() >= b.getMass()) {
                        a.mergeWith(b);
                        toRemove.add(b);
                    } else {
                        b.mergeWith(a);
                        toRemove.add(a);
                        break;
                    }
                }
            }

            if (a.isStar() && a.getChildren().isEmpty() && frameCount % 60 == 0) {
                spawnPlanetarySystem(a);
            }
            if (a.getType() == CelestialBody.BodyType.GALAXY_CORE && !bodies.contains(a)) {
                bodies.add(a);
            }
        }

        particles.removeAll(toRemove);
        particles.removeIf(p -> !p.isAlive());

        if (simulationTime > 100) {
            for (Particle p : particles) {
                Vector3d pos = p.getPosition();
                double dist = pos.length();
                if (dist > 100) {
                    Vector3d expansion = new Vector3d(pos).normalize().mul(Constants.DARK_ENERGY_FACTOR * dist * dt);
                    p.getVelocity().add(expansion);
                }
            }
        }
    }

    private void spawnPlanetarySystem(Particle star) {
        Random rand = new Random(star.getId().hashCode());
        int numPlanets = 3 + rand.nextInt(8);
        double inner = 10 + star.getMass() * 0.1;
        for (int i = 0; i < numPlanets; i++) {
            double dist = inner + i * (8 + rand.nextDouble() * 5);
            double angle = rand.nextDouble() * Math.PI * 2;
            double speed = Math.sqrt(Constants.SIM_G * star.getMass() / dist) * (0.9 + rand.nextDouble() * 0.2);
            Vector3d pos = new Vector3d(Math.cos(angle) * dist, Math.sin(angle) * dist, (rand.nextDouble()-0.5)*2);
            Vector3d vel = new Vector3d(-Math.sin(angle) * speed, Math.cos(angle) * speed, 0);
            double mass = Constants.MIN_PLANET_MASS + rand.nextDouble() * (Constants.MAX_PLANET_MASS - Constants.MIN_PLANET_MASS);
            double density = 2 + rand.nextDouble() * 5;
            Planet planet = new Planet(pos, vel, mass, density);
            planet.setParent(star);
            planet.setSemiMajorAxis(dist);
            planet.setEccentricity(rand.nextDouble() * 0.1);
            planet.setInclination(rand.nextDouble() * 0.1);

            if (dist >= Constants.HABITABLE_INNER && dist <= Constants.HABITABLE_OUTER) {
                planet.setHasAtmosphere(true);
                planet.setAtmosphereThickness(1 + rand.nextDouble() * 3);
                planet.setAtmosphereColor(new Vector3f(0.5f, 0.7f, 1.0f));
                if (planet.isHabitable() && rand.nextDouble() < 0.7) {
                    planet.setLifeForm(new LifeForm());
                }
            }
            star.addChild(planet);
            particles.add(planet);
        }
    }

    public double getSimulationTime() { return simulationTime; }

    private static class Octree {
        Vector3d min, max, center;
        double totalMass;
        Vector3d com;
        Particle particle;
        boolean hasParticle = false;
        Octree[] children;

        Octree(Vector3d min, Vector3d max) {
            this.min = new Vector3d(min);
            this.max = new Vector3d(max);
            this.center = new Vector3d(min).add(max).mul(0.5);
            this.com = new Vector3d(0);
            this.totalMass = 0;
        }

        void insert(Particle p) {
            if (!contains(p.getPosition())) return;
            if (!hasParticle && totalMass == 0) {
                particle = p;
                hasParticle = true;
                totalMass = p.getMass();
                com.set(p.getPosition());
                return;
            }
            if (hasParticle) {
                subdivide();
                insertIntoChildren(particle);
                hasParticle = false;
                particle = null;
            }
            insertIntoChildren(p);
        }

        boolean contains(Vector3d p) {
            return p.x >= min.x && p.x <= max.x && p.y >= min.y && p.y <= max.y && p.z >= min.z && p.z <= max.z;
        }

        void subdivide() {
            children = new Octree[8];
            Vector3d mid = center;
            for (int i = 0; i < 8; i++) {
                Vector3d cmin = new Vector3d((i & 1) == 0 ? min.x : mid.x, (i & 2) == 0 ? min.y : mid.y, (i & 4) == 0 ? min.z : mid.z);
                Vector3d cmax = new Vector3d((i & 1) == 0 ? mid.x : max.x, (i & 2) == 0 ? mid.y : max.y, (i & 4) == 0 ? mid.z : max.z);
                children[i] = new Octree(cmin, cmax);
            }
        }

        void insertIntoChildren(Particle p) {
            for (Octree child : children) {
                if (child.contains(p.getPosition())) { child.insert(p); return; }
            }
        }

        Vector3d calculateForce(Particle p, double theta) {
            if (totalMass == 0) return new Vector3d(0);
            double size = max.x - min.x;
            double dist = center.distance(p.getPosition());
            if (!hasParticle && size / dist < theta) {
                return gravitationalForce(p, com, totalMass);
            }
            Vector3d f = new Vector3d(0);
            if (hasParticle && particle != p) {
                f.add(gravitationalForce(p, particle.getPosition(), particle.getMass()));
            }
            if (children != null) {
                for (Octree child : children) f.add(child.calculateForce(p, theta));
            }
            return f;
        }

        Vector3d gravitationalForce(Particle p, Vector3d otherPos, double otherMass) {
            Vector3d dir = new Vector3d(otherPos).sub(p.getPosition());
            double dist = dir.length();
            if (dist < Constants.SOFTENING) dist = Constants.SOFTENING;
            double f = Constants.SIM_G * p.getMass() * otherMass / (dist * dist);
            return dir.normalize().mul(f);
        }
    }
}

class NameGenerator {
    private static final String[] PREFIXES = {"Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Iota", "Kappa", "Lambda", "Sigma", "Tau", "Omega", "Proxima", "Ultima", "Nova", "Sol", "Vega", "Sirius", "Rigel", "Deneb", "Altair", "Fomalhaut", "Achernar", "Aldebaran", "Antares", "Arcturus", "Betelgeuse", "Canopus", "Capella", "Castor", "Pollux", "Regulus", "Spica"};
    private static final String[] ROOTS = {"Centauri", "Cygni", "Lyrae", "Orionis", "Draconis", "Pegasi", "Andromedae", "Cassiopeiae", "Persei", "Aquilae", "Aurigae", "Bootis", "Crucis", "Eridani", "Herculis", "Leonis", "Scorpii", "Tauri", "Ursae", "Virginis", "Ceti", "Piscium", "Aquarii", "Capricorni", "Sagittarii"};
    private static final String[] SUFFIXES = {"Prime", "Major", "Minor", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "b", "c", "d", "e", "f"};

    public static String generateStarName(long seed) {
        SeededRandom r = new SeededRandom(seed);
        return PREFIXES[r.nextInt(PREFIXES.length)] + " " + ROOTS[r.nextInt(ROOTS.length)];
    }

    public static String generatePlanetName(String starName, int index) {
        return starName + " " + SUFFIXES[index % SUFFIXES.length];
    }

    public static String generateGalaxyName(long seed) {
        SeededRandom r = new SeededRandom(seed);
        String[] g = {"Milky", "Andromeda", "Triangulum", "Whirlpool", "Sombrero", "Pinwheel", "Cartwheel", "Sunflower", "Black", "Silver", "Golden", "Crystal", "Phantom", "Eternal"};
        return g[r.nextInt(g.length)] + " " + (r.nextBoolean() ? "Way" : "Stream");
    }
}

class Renderer {
    private int vao, vbo;
    private int shaderProgram;
    private int mvpLocation, colorLocation, pointSizeLocation;
    private Matrix4f mvp;
    private FloatBuffer buffer;

    private static final String VERTEX_SHADER =
        "#version 330 core\n" +
        "layout(location=0) in vec3 position;\n" +
        "uniform mat4 mvp;\n" +
        "uniform float pointSize;\n" +
        "void main() {\n" +
        "    gl_Position = mvp * vec4(position, 1.0);\n" +
        "    gl_PointSize = pointSize;\n" +
        "}";

    private static final String FRAGMENT_SHADER =
        "#version 330 core\n" +
        "out vec4 fragColor;\n" +
        "uniform vec3 color;\n" +
        "void main() {\n" +
        "    float dist = length(gl_PointCoord - vec2(0.5));\n" +
        "    if (dist > 0.5) discard;\n" +
        "    float alpha = 1.0 - smoothstep(0.3, 0.5, dist);\n" +
        "    fragColor = vec4(color, alpha);\n" +
        "}";

    public Renderer() {
        mvp = new Matrix4f();
        buffer = MemoryUtil.memAllocFloat(15000 * 3);
    }

    public void init() {
        GL.createCapabilities();
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_PROGRAM_POINT_SIZE);

        vao = GL30.glGenVertexArrays();
        vbo = GL15.glGenBuffers();
        GL30.glBindVertexArray(vao);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
        GL20.glEnableVertexAttribArray(0);
        GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);

        shaderProgram = createShader(VERTEX_SHADER, FRAGMENT_SHADER);
        mvpLocation = GL20.glGetUniformLocation(shaderProgram, "mvp");
        colorLocation = GL20.glGetUniformLocation(shaderProgram, "color");
        pointSizeLocation = GL20.glGetUniformLocation(shaderProgram, "pointSize");
    }

    private int createShader(String vert, String frag) {
        int vs = GL20.glCreateShader(GL20.GL_VERTEX_SHADER);
        GL20.glShaderSource(vs, vert);
        GL20.glCompileShader(vs);
        int fs = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER);
        GL20.glShaderSource(fs, frag);
        GL20.glCompileShader(fs);
        int prog = GL20.glCreateProgram();
        GL20.glAttachShader(prog, vs);
        GL20.glAttachShader(prog, fs);
        GL20.glLinkProgram(prog);
        return prog;
    }

    public void render(List<CelestialBody> bodies, Camera camera, int width, int height) {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glClearColor(0.02f, 0.02f, 0.04f, 1.0f);

        Matrix4f projection = new Matrix4f().perspective((float)Math.toRadians(60), (float)width/height, 0.01f, 1e9f);
        Matrix4f view = camera.getViewMatrix();
        mvp.set(projection).mul(view);

        GL20.glUseProgram(shaderProgram);
        GL30.glBindVertexArray(vao);

        int count = 0;
        buffer.clear();
        Vector3d camPos = camera.getPosition();

        for (CelestialBody b : bodies) {
            if (!b.isAlive()) continue;
            Vector3d pos = b.getPosition();
            double dist = pos.distance(camPos);
            double screenSize = b.getRadius() / Math.max(1, dist) * height;

            if (screenSize < 0.5 && dist > 100) {
                buffer.put((float)pos.x).put((float)pos.y).put((float)pos.z);
                count++;
                if (count >= 5000) break;
            } else {
                renderBody(b, dist);
            }
        }

        if (count > 0) {
            buffer.flip();
            GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
            GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STREAM_DRAW);
            GL20.glUniformMatrix4fv(mvpLocation, false, mvp.get(new float[16]));
            GL20.glUniform3f(colorLocation, 1.0f, 1.0f, 1.0f);
            GL20.glUniform1f(pointSizeLocation, 2.0f);
            GL11.glDrawArrays(GL11.GL_POINTS, 0, count);
        }
    }

    private void renderBody(CelestialBody b, double dist) {
        Vector3f col = b.getColor();
        float size = (float)(b.getRadius() / Math.max(1, dist)) * 100;
        size = Math.max(2, Math.min(50, size));
        GL20.glUniform3f(colorLocation, col.x, col.y, col.z);
        GL20.glUniform1f(pointSizeLocation, size);
    }

    public void cleanup() {
        GL30.glDeleteVertexArrays(vao);
        GL15.glDeleteBuffers(vbo);
        GL20.glDeleteProgram(shaderProgram);
        MemoryUtil.memFree(buffer);
    }
}

class Camera {
    private Vector3d position;
    private Vector3d target;
    private Vector3f up;
    private double distance;
    private double yaw, pitch;
    private float moveSpeed = 50.0f;
    private double zoomSpeed = 1.1;
    private boolean freeMode = false;
    private Vector3d freeVelocity = new Vector3d();
    private boolean characterMode = false;
    private Vector3d characterPos = new Vector3d();
    private float characterYaw, characterPitch;
    private CelestialBody focusedBody;

    public Camera() {
        position = new Vector3d(0, 0, 500);
        target = new Vector3d(0, 0, 0);
        up = new Vector3f(0, 1, 0);
        distance = 500;
        yaw = -Math.PI / 2;
        pitch = 0;
    }

    public void update(double dt, long window) {
        if (characterMode) {
            updateCharacterMode(dt, window);
            return;
        }
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_Q) == GLFW.GLFW_PRESS) distance *= (1 + zoomSpeed * dt);
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_E) == GLFW.GLFW_PRESS) distance /= (1 + zoomSpeed * dt);
        distance = Math.max(0.1, Math.min(1e8, distance));

        if (GLFW.glfwGetMouseButton(window, GLFW.GLFW_MOUSE_BUTTON_RIGHT) == GLFW.GLFW_PRESS) {
            double[] mx = new double[1], my = new double[1];
            GLFW.glfwGetCursorPos(window, mx, my);
            yaw += mx[0] * 0.005;
            pitch += my[0] * 0.005;
            pitch = Math.max(-Math.PI/2 + 0.01, Math.min(Math.PI/2 - 0.01, pitch));
            GLFW.glfwSetCursorPos(window, 0, 0);
        }

        if (freeMode) {
            Vector3d forward = new Vector3d(Math.cos(yaw)*Math.cos(pitch), Math.sin(pitch), Math.sin(yaw)*Math.cos(pitch));
            Vector3d right = new Vector3d(Math.cos(yaw-Math.PI/2), 0, Math.sin(yaw-Math.PI/2));
            if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_W) == GLFW.GLFW_PRESS) freeVelocity.add(new Vector3d(forward).mul(moveSpeed * dt * distance * 0.01));
            if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_S) == GLFW.GLFW_PRESS) freeVelocity.sub(new Vector3d(forward).mul(moveSpeed * dt * distance * 0.01));
            if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_A) == GLFW.GLFW_PRESS) freeVelocity.sub(new Vector3d(right).mul(moveSpeed * dt * distance * 0.01));
            if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_D) == GLFW.GLFW_PRESS) freeVelocity.add(new Vector3d(right).mul(moveSpeed * dt * distance * 0.01));
            position.add(freeVelocity);
            freeVelocity.mul(0.95);
            target.set(position).add(forward);
        } else {
            Vector3d offset = new Vector3d(Math.cos(yaw)*Math.cos(pitch)*distance, Math.sin(pitch)*distance, Math.sin(yaw)*Math.cos(pitch)*distance);
            if (focusedBody != null) target.set(focusedBody.getPosition());
            position.set(target).add(offset);
        }
    }

    private void updateCharacterMode(double dt, long window) {
        Vector3d forward = new Vector3d(Math.cos(characterYaw)*Math.cos(characterPitch), Math.sin(characterPitch), Math.sin(characterYaw)*Math.cos(characterPitch));
        Vector3d right = new Vector3d(Math.cos(characterYaw-Math.PI/2), 0, Math.sin(characterYaw-Math.PI/2));
        double speed = GLFW.glfwGetKey(window, GLFW.GLFW_KEY_LEFT_SHIFT) == GLFW.GLFW_PRESS ? 15.0 : 5.0;
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_W) == GLFW.GLFW_PRESS) characterPos.add(new Vector3d(forward).mul(speed*dt));
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_S) == GLFW.GLFW_PRESS) characterPos.sub(new Vector3d(forward).mul(speed*dt));
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_A) == GLFW.GLFW_PRESS) characterPos.sub(new Vector3d(right).mul(speed*dt));
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_D) == GLFW.GLFW_PRESS) characterPos.add(new Vector3d(right).mul(speed*dt));
        if (GLFW.glfwGetMouseButton(window, GLFW.GLFW_MOUSE_BUTTON_RIGHT) == GLFW.GLFW_PRESS) {
            double[] mx = new double[1], my = new double[1];
            GLFW.glfwGetCursorPos(window, mx, my);
            characterYaw += mx[0] * 0.003;
            characterPitch -= my[0] * 0.003;
            characterPitch = Math.max(-Math.PI/2+0.01, Math.min(Math.PI/2-0.01, characterPitch));
            GLFW.glfwSetCursorPos(window, 0, 0);
        }
        position.set(characterPos);
        target.set(characterPos).add(forward);
    }

    public void enterCharacterMode(CelestialBody planet, Vector3d surfacePos) {
        characterMode = true;
        characterPos.set(surfacePos);
        characterYaw = 0;
        characterPitch = 0;
        focusedBody = planet;
    }

    public void exitCharacterMode() {
        characterMode = false;
        distance = focusedBody != null ? focusedBody.getRadius() * 5 : 100;
    }

    public boolean isCharacterMode() { return characterMode; }
    public void setFreeMode(boolean f) { freeMode = f; }
    public boolean isFreeMode() { return freeMode; }

    public void focusOn(CelestialBody body) {
        focusedBody = body;
        target.set(body.getPosition());
        distance = body.getRadius() * 5 + 50;
    }

    public CelestialBody getFocusedBody() { return focusedBody; }

    public Matrix4f getViewMatrix() {
        Vector3f eye = new Vector3f((float)position.x, (float)position.y, (float)position.z);
        Vector3f center = new Vector3f((float)target.x, (float)target.y, (float)target.z);
        return new Matrix4f().lookAt(eye, center, up);
    }

    public Vector3d getPosition() { return position; }
    public void setPosition(Vector3d p) { position.set(p); }
    public double getDistance() { return distance; }
}

class CharacterController {
    private Vector3d worldPosition;
    private Vector3d velocity;
    private boolean onGround;
    private CelestialBody currentPlanet;
    private double heightAboveSurface = 1.7;

    public CharacterController() {
        worldPosition = new Vector3d();
        velocity = new Vector3d();
    }

    public void spawnOnPlanet(CelestialBody planet, double latitude, double longitude) {
        this.currentPlanet = planet;
        double r = planet.getRadius() + heightAboveSurface;
        double lat = Math.toRadians(latitude);
        double lon = Math.toRadians(longitude);
        worldPosition.set(Math.cos(lat)*Math.cos(lon)*r, Math.sin(lat)*r, Math.cos(lat)*Math.sin(lon)*r);
        onGround = true;
    }

    public Vector3d getWorldPosition() { return worldPosition; }
    public CelestialBody getCurrentPlanet() { return currentPlanet; }
    public boolean isOnGround() { return onGround; }
}
