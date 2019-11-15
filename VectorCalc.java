package vectorComponentCalc;

/*
This is the latest version of my vector calculator.
Gotta secure that extra credit ykyk

Stuff it's gotta have:
1. The scanner has to accept the magnitudes and directions of two given vectors. DONE
2. It has to calculate at least the x-components and sum them DONE
    a. You have to prompt the user if the vector's negative or positive based on its location. Maybe make a boolean scanner? DONE
3. It calculates the y-components and sum them DONE
4. It uses pythagorean theorem to calculate the displacement of the vectors DONE
5. It should be able to let the person input its direction
5. Ta-da! Ms. Wolcott pls be proud I spent like 2 hours on this instead of doing my actual hw
*/

import java.util.Scanner; //to introduce Scanner cmd

public class VectorCalc {
    public static void main(String[ ] args) {
        Scanner sc = new Scanner(System.in);
    //Code to calculate pythagoran theorem
        /*System.out.println("Please input the legs of a right triangle you'd like to calculate.");
        double v1 = sc.nextDouble();
        System.out.println("\nValue one: " + v1);
        double v2 = sc.nextDouble();
        System.out.println("Value two: " + v2 + "\n");
        double eq1 = pyth(v1, v2);
        */ 
    //Code that accepts the magnitude of the two vectors
        System.out.println("Welcome to the Jude Gadingan's Two-Vector Calculator!\n\nPlease input the magnitude of the two vectors.");
        double l1 = sc.nextDouble();
        System.out.println("\nValue one: " + l1);
        double l2 = sc.nextDouble();
        System.out.println("Value two: " + l2 + "\n");
    //Code that accepts the direction of the two vectors
        System.out.println("Now, please enter the direction of the two vectors \nin the same order you entered the magnitudes of each.");
        double d1 = sc.nextDouble();
        System.out.println("\nDirection of vector one in degrees: " + d1);
        double d2 = sc.nextDouble();
        System.out.println("Direction of vector two in degrees: " + d2);
    //Code to calculate and sum the vectors' x-components
        //First vector's x-component
        double xcom1 = xcom(l1, d1);
         //Asks if the first x-component value is positive or negative
         System.out.println("\nThe value of the first x-component is " + (float)xcom1);
        //Second vector's x-component
        double xcom2 = xcom(l2, d2);
         System.out.println("The value of the second x-component is " + (float)xcom2);   //Asks if the second x-component is positive or negative
        double sumValX = xcom1 + xcom2;
        System.out.println("\n[Ex = " + (float)sumValX + "]");      //prints out the sum of both x-components
    //Code to calculate and sum the vectors' y-components
        //First vector's y-component
        double ycom1 = ycom(l1, d1);
         System.out.println("\nThe value of the first y-component is " + (float)ycom1);   //Asks if the second x-component is positive or negative
        //Second vector's y-component
        double ycom2 = ycom(l2, d2);
         System.out.println("\nThe value of the second y-component is " + (float)ycom2);   //Asks if the second x-component is positive or negative
         double sumValY = ycom1 + ycom2; 
        System.out.println("\n[Ey = " + (float)sumValY + "]");
        //Time to bring it all together again
        double finalResult = pyth(sumValX, sumValY);
        double finalResultRounded = round(finalResult, 2);
        System.out.println("The resultant of these two vectors amounts to \n...\n..\n. " + finalResultRounded);
        //Now for the direction
        //We use arctan to calculate the degree or direction of the vector, so:
        double direction = tan(sumValY/sumValX);      //calls upon the arctan method to find the inverse tangent
        //Checks the direction of the vectors to make sure it's calculated properly
        double check = checkD(direction);
        String compass = compassCalc(sumValX, sumValY, direction);		//calls on a method to determine the direction of the resultant velocity.
        System.out.println("\n The direction of the vectors is " + round(check, 0) + " degrees " + compass + ".");
    }
        
//Methods and all that cool hidden stuff
        //method for calculating pythagoran theorem
        public static double pyth(double x, double y){
            double x2 = Math.pow(x, 2);
            double y2 = Math.pow(y, 2);
            double val = Math.sqrt(x2 + y2);
            return val;
    }
        //method for adding up two values, pretty useless considering I didn't use it the entirety of the program
        public static double sum2(double x, double y){
            double sum = x + y;
            return sum;
    }
        //method to calculate cos in degrees
        public static double cos(double x){
            double deg = x;
            double rad = (Math.toRadians(deg));
            double equ = Math.cos(rad);
            return equ;
    }
        //method to calculate sine in degrees
        public static double sin(double x){
            double deg = x;
            double rad = (Math.toRadians(deg));
            double equ = Math.sin(rad);
            return equ;
        }
        //method to calculate inverse tan (arctan) in degrees
        public static double tan(double x){
            double deg = x;
            double equ = Math.toDegrees(Math.atan(deg));
            return equ;
        }
       // method to calculate an x-component
        public static double xcom(double x, double y){
            double cosD = cos(y);
            double val = x * cosD;
            return val;
        }
        
        // method to calculate a y-component
        public static double ycom(double x, double y){
            double sinD = sin(y);
            double val = x * sinD;
            return val;
        }
        //method that I found to round a double to the nearest 2 decimal points
        public static double round(double value, int places) {
            if (places < 0) throw new IllegalArgumentException();
            long factor = (long) Math.pow(10, places);
            value = value * factor;
            long tmp = Math.round(value);
            return (double) tmp / factor;
}
    //method to check if the final direction is in the second, third, or fourth quadrant
        public static double checkD(double x){
            if(x > 90 && x < 180){
            x = 180 - x;
        }
        else if(x > 90 && x > 270){
            x = 180 + x;
             }
        else if(x < 0 && x >= -90){
            x = 180 + x;
        }
        else if(x < -90 && x < -270){
            x = 270 + x;
        }
             return x;
        }
        
        
   //Method that detects the direction of the resultant vector based on the position of its x and y components.
        public static String compassCalc(double x, double y, double d) {
        	String text = null;
        	if(x == x && y == y) {
        		if(d == 45) {
        			text = "northeast";
        		}
        		text = "north of east";
        		return text;
        	}
        	else if(x == x && y == -y) {
        		if(d == 45) {
        			text = "southeast";
        		}
        		text = "south of east";
        		return text;
        	}
        	else if(x == -x && y == -y) {
        		if(d == 45) {
        			text = "southwest";
        			
        		}
        		text = "south of west";
        		return text;
        	}
        	else if(x == -x && y == y) {
        		if(d == 45) {
        			text = "northwest";
        		}
        		text = "north of west";
        		return text;
        	}
        	return text;
        }
        //code that I might put back later
        /*if(direction > 90 && direction < 270){
            double minus180 = 180 - direction;
        }
        else if(direction > 90 && direction > 270){
            double minus270 = 270 - direction;
             }
             */
}
