//Expected Reciprocal Rank Implementation ---ERR@K  by Niranjan Kumar

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ERR {
    public static void main(String[] args) throws IOException, NumberFormatException {

        int documentCount=0;

        double ExpectedReciprocalRank = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Number of Documents");
        documentCount = Integer.parseInt(bufferedReader.readLine());

        double [] grade = new double [documentCount];
        double [] probabilitySatifactionOfDocument = new double [documentCount];
        double [] probabilityOfStopDocument = new double[documentCount];

        for (int i = 0; i < documentCount; i++){
            System.out.println("Enter Document " +(i+1) +" Grade");
            grade[i] = Integer.parseInt(bufferedReader.readLine());
        }
        for(int i = 0; i< documentCount; i++){
            probabilitySatifactionOfDocument[i] = (Math.pow(2,grade[i])-1)/16;
            double temp = 1;
            if(i == 0){
                probabilityOfStopDocument[i] = probabilitySatifactionOfDocument[i];
            }else {
                for (int j = i-1; j >= 0 ; j--){
                    temp = temp * (1-probabilitySatifactionOfDocument[j]);
                }
            }
            probabilityOfStopDocument[i] = probabilitySatifactionOfDocument[i]*temp;
        }
        System.out.println("Probability Satisfaction of Document");
        for (int i = 0 ; i < documentCount ; i++) {
            System.out.println(probabilitySatifactionOfDocument[i]);
        }
        System.out.println("Probability Stop at Document K");
        for (int i = 0 ; i < documentCount ; i++) {
            System.out.println(probabilityOfStopDocument[i]);
        }
        for (int document =0 ; document <documentCount ; document++){
            double productCalulation = (1/(document+1.0))*probabilityOfStopDocument[document] ;
            ExpectedReciprocalRank = ExpectedReciprocalRank + productCalulation;
        }
        System.out.println("ExpectedReciprocalRank@"+documentCount+"="+ExpectedReciprocalRank);
        /*System.out.println("Entered Grades are:");
        for (int i = 0 ; i < documentCount ; i++){
            System.out.println(grade[i]);
        }*/
        //Compute the proability satisfaction of document k
        /*for (int k = 0 ; k < documentCount ; k++){
            probabilitySatifactionOfDocument[k] = (Math.pow(2,grade[k]) - 1)/16;
        }
        System.out.println("Probability Satisfaction of Document");
        for (int i = 0 ; i < documentCount ; i++) {
            System.out.println(probabilitySatifactionOfDocument[i]);
        }
        probabilityOfStopDocument[0]  = probabilitySatifactionOfDocument[0];
        for (int j = 1 ; j < documentCount ; j++ ){
            for (int k =0 ; k < j ; k++){
                probabilityOfStopDocument[j] = probabilitySatifactionOfDocument[j] * (1- probabilitySatifactionOfDocument[j-1]);
            }

        }
        System.out.println("Probability Stop at Document K");
        for (int i = 0 ; i < documentCount ; i++) {
            System.out.println(probabilityOfStopDocument[i]);
        }*/
    }
}
