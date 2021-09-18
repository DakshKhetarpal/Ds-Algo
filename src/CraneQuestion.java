public class CraneQuestion {
    public static void main(String[] args){

        int[] A={2,1};
        int[] P={5,1};
        int B=2;
        int E=6;
        System.out.println(solveCrane(A,P,B,E));
    }

    static boolean solveCrane(int[] A,int[] P, int B, int E){

        int[] solArr=new int[100];
        for(int i=0;i<A.length;i++){
                int upperRange=P[i]+A[i];
                int lowerRange=P[i]-A[i];
                if(upperRange<0)
                    upperRange=0;
                if(lowerRange<0)
                    lowerRange=0;
                for(int j=lowerRange;j<=upperRange;j++){
                    if(j==lowerRange)
                        solArr[j]=20+solArr[j];

                    else if(j==upperRange)
                        solArr[j]=20+solArr[j];

                    else
                       solArr[j]=1+solArr[j];
                }

        }
        if(B<=E){
            for(int i=B;i<=E;i++){
                if(solArr[i]==20 && i==B){
                    continue;
                }
                else if(solArr[i]==20 && i==E){
                    continue;
                }
                else if(solArr[i]==20 && (i!=B || i!=E)){
                    return false;
                }
                else if(solArr[i]==0)
                    return false;
            }
            return true;
        }else{

            for(int i=E;i<=B;i++){
                if(solArr[i]==20 && i==B){
                    continue;
                }
                else if(solArr[i]==20 && i==E){
                    continue;
                }
                else if(solArr[i]==20 && (i!=B || i!=E)){
                    return false;
                }
                else if(solArr[i]==0)
                    return false;
            }
            return true;

        }
    }
}
