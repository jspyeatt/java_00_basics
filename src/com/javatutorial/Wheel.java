package com.javatutorial;

// declaring our Wheel class
public class Wheel {
    // the only attribute we are setting is the radius.
    double radiusInMeters;

    /**
     * Create a wheel with a certain radius
     * @param r radius in meters
     */
    public Wheel(double r) {
        radiusInMeters = r;
    }

    @Override
    public String toString() {
        return "Wheel[" + radiusInMeters + "]";
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || (o instanceof Wheel) == false) {
            return false;
        }
        Wheel b = (Wheel) o;
        return radiusInMeters == b.radiusInMeters;
    }
    /**
     * Calculate the speed in meters per second if you roll the wheel at a certain RPM
     * @param rpm revolutions per minute
     * @return speed in meters per second.
     */
    public double getSpeedInMPS(int rpm) {

        // this is 2 * pi * radius * rpm then we divid by 60 to get rate in seconds instead of minutes.
        double speed = (2.0 * 3.141592 * radiusInMeters) * rpm / 60.0;
        return speed;
    }

    /**
     * Get the distance the wheel travels given an RPM and how long to roll
     * @param rpm revolutions per minute
     * @param timeInSecs amount of time to roll
     * @return distance in meters
     */
    public double getDistanceTraveled(int rpm, int timeInSecs) {

        // note we are just calling our speed function then multiplying it by our duration.
        return getSpeedInMPS(rpm) * timeInSecs;
    }

    /**
     * Calculate how long a wheel will drop until it hits the ground given a height of the drop and assuming
     * no friction.
     *
     * @param heightInMeters height we will drop from.
     * @return time in seconds until it hits the ground.
     */
    public double drop(double heightInMeters) {
        // putting the word final in here means it is a constant. In this case, the acceleration of gravity.
        final double gravity = 9.8;

        // Math.sqrt is the square root function. This comes with the java language.
        return Math.sqrt(2.0 * heightInMeters/gravity);
    }

    public static void main(String[] args) {
        Wheel w1 = new Wheel(100);
        Wheel w2 = new Wheel(15);
        System.out.println("At 50 rpm wheel 1 goes " + w1.getSpeedInMPS(50) + " at wheel 2 goes " + w2.getSpeedInMPS(50));

        System.out.println("Wheel 1 at 70 rpm for 8 seconds goes this far " + w1.getDistanceTraveled(70,8));
        System.out.println("Wheel 2 at 200 rpm for 12 seconds goes this far " + w2.getDistanceTraveled(200, 12));

        System.out.println("Dropping a wheel from 500 meters takes this long to hit the ground " + w1.drop(500));
    }
}
