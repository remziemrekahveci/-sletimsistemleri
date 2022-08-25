public class REK {
 public static int n = 4; 
 public static int m = 3; 
 public static int [] resource = {9, 3, 6}; 
 public static int[][] Cliam = { { 3, 2, 2 }, { 6, 1, 3 }, { 3, 1, 4 }, { 4, 2, 2 } };
 public static int[][] Allocate = new int[n][m];
 public static int[][] Need = { { 3, 2, 2 }, { 6, 1, 3 }, { 3, 1, 4 }, { 4, 2, 2 } };
 public static int[] Available = { 9, 3, 6 };
 public int[][] state = new int[n][m];
 
 
 
 public static void main(String args[]) {

 REK ban = new REK();
 int[][][] re={{{1},{1,0,0}},{{2},{2,1,0}},{{2},{2,0,1}},{{3},{2,1,1}},{{4},{0,0,2}},{{2},{1,0,1}},{{1},{1,0,1}}};
 for(int j=0;j<re.length;j++){
 
 ban.judgeqingqiu (re [j] [1], re [j] [0] [0] - 1, j);
 }
 
 
 }

 public void judgeqingqiu(int[] Request, int i,int j) {
 
 if (judgementrequest(Request, i) && judgementrequest(Request, i)) {
 distribute (Request, i); 
 if (judgementsafe(Allocate)) {
 
 System.out.println("############");
 System.out.println ("the" + (j + 1) + "request" + "process" + (i + 1) + "request resource is allowed");
 printJuzhen("Allocate", Allocate);
 printJuzhen("Need", Need);
 PrintXianglaing("Available", Available);
 } else {
 System.out.println("############");
 System.out.println ("the" + (j + 1) + "request" + "process" + (i + 1) + "request resource rejected");
 erWeiCopy(Allocate, state);
 }
 } else {
 System.out.println("*****************");
 System.out.println ("the" + (j + 1) + "request" + "process" + (i + 1) + "request resource rejected");
 }
 }
 
 
 public void distribute(int[] Request,int i) {

 state = erWeiCopy (state, Allocate); 
 Allocate = addrequest (Allocate, Request, i); 
 Need = reducerequest (Need, Allocate); 
 Available = AvaileReduceRequest (Available, Allocate);
 }
 
 public boolean judgementsafe(int[][] Allocate) {
 int [] work = new int [m];
 work = yiweicopy (work, Available); 
 Boolean safe = true; 
 Boolean [] finish = {false, false, false, false}; 
 
 for (int j = 0; j < n; j++) {
 
 if (judgementsafeWork(Need[j], work) && finish[j] == false) {
  finish [j] = true; 
  for (int h = 0; h < m; h++) {
  work[h] = work[h] + Allocate[j][h];
  }
  j = - 1; 
 }
 }
 
 for (int m = 0; m < n; m++) {
 if (finish[m] == false) {
  safe = false;
 }
 }
 return safe;
 }

 public boolean judgementsafeWork(int[] Request, int[] work) {
 for (int k = 0; k < m; k++) {

 if (Request[k] >work[k]) {
  return false;
 }
 }
 return true; 

 }

 public boolean judgementrequest(int[] Request, int i) {
 
 for (int j = 0; j < m; j++) {
 if (Request[j] > Need[i][j]) {
 return false;
 }
 }
 
 return true;
 }

 public boolean judgementAvali(int[] Request) {
 for (int j = 0; j < m; j++) {
 if (Request[j] >Available[j]) {
 return false;
 }
 }
 return true;

 }

 public int[][] addrequest(int[][] Allocate, int[] Request, int i) {

 for (int h = 0; h < m; h++) {
 Allocate[i][h] = Allocate[i][h] + Request[h];
 }

 return Allocate;

 }

 public int[][] reducerequest(int[][] Need, int[][] state) {
 for (int j = 0; j < n; j++) {
 for (int h = 0; h < m; h++) {
 Need[j][h] = Cliam[j][h] - state[j][h];
 }
 }
 return Need;
 }

 public int[] AvaileReduceRequest(int[] Available, int[][] Allocate) {
 Available = yiweicopy(Available, resource);
 for (int j = 0; j < n; j++) {
 for (int h = 0; h < m; h++) {
 Available[h] = Available[h] - Allocate[j][h];
 }
 }
 return Available;
 }
 
 public int[][] erWeiCopy(int[][] x1, int[][] y1) {
 for (int j = 0; j < n; j++) {
 for (int h = 0; h < m; h++) {
 x1[j][h] = y1[j][h];
 }
 }
 return x1;
 }

 public int[] yiweicopy(int[] x1, int[] y1) {
 for (int j = 0; j < m; j++) {
 x1[j] = y1[j];
 }
 return x1;
 }

 public static void PrintXianglaing(String id, int[] x) {
 System.out.println(id);
 for (int j = 0; j < x.length; j++) {
 System.out.print(x[j] + " ");
 }
 System.out.println("");
 }

 public static void printJuzhen(String id, int[][] y) {
 System.out.println(id);
 for (int j = 0; j < n; j++) {
 for (int h = 0; h < m; h++) {
 System.out.print(y[j][h] + " ");
 }
 System.out.println();
 }
 }

}