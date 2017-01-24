package iha.otr_01;

import java.util.ArrayList;
import java.util.Iterator;

public class App 
{
	public class IPAddress implements Cloneable{
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		
		private boolean IsIndexOutOfBound(int ip){
			if ((ip >= 0) && (ip <= 255)) 
				return true;
			else
				return false;
		}
		
		public IPAddress(){}
		
		public IPAddress(int a, int b, int c, int d){
			
			if (this.IsIndexOutOfBound(a)) this.a = a; else throw new IndexOutOfBoundsException();
			
			if (this.IsIndexOutOfBound(b)) this.b = b; else throw new IndexOutOfBoundsException();
			
			if (this.IsIndexOutOfBound(c)) this.c = c; else throw new IndexOutOfBoundsException();
			
			if (this.IsIndexOutOfBound(d)) this.d = d; else throw new IndexOutOfBoundsException();
		}

		public IPAddress(String str){
			this.convert(str);
			
			if (this.IsIndexOutOfBound(a)) this.a = a; else throw new IndexOutOfBoundsException();
			
			if (this.IsIndexOutOfBound(b)) this.b = b; else throw new IndexOutOfBoundsException();
			
			if (this.IsIndexOutOfBound(c)) this.c = c; else throw new IndexOutOfBoundsException();
			
			if (this.IsIndexOutOfBound(d)) this.d = d; else throw new IndexOutOfBoundsException();
		}
		
		
		@Override
		public boolean equals(Object ip) {
			if (!(ip instanceof IPAddress)) return false;
			
			if (
					(((IPAddress)ip).a == this.a) &&
					(((IPAddress)ip).b == this.b) &&
					(((IPAddress)ip).c == this.c) &&
					(((IPAddress)ip).d == this.d)
				) 
				return true;
			else 
				return false;
		}

		@Override
		public int hashCode() {
	        int hash = 1;
	        
	        hash = hash * 17 + a;
	        hash = hash * 31 + b;
	        hash = hash * 13 + c;
	        hash = hash * 45 + d;
	        
	        return hash;
	 	}
		
		@Override
		public String toString() {
			String str = "IP " +
					Integer.toString(a) + "." +
					Integer.toString(b) + "." +
					Integer.toString(c) + "." +
					Integer.toString(d) + "\n";
			return str;
		}

		public boolean gt(IPAddress ip){
			if (this.a > ip.a) return true;
			if (this.a < ip.a) return false;
			if (this.b > ip.b) return true;
			if (this.b < ip.b) return false;
			if (this.c > ip.c) return true;
			if (this.c < ip.c) return false;
			if (this.d > ip.d) return true;
			return false;
		}
		
		public void printIPToConsole() {
			String str = "IP " +
					Integer.toString(this.a) + "." +
					Integer.toString(this.b) + "." +
					Integer.toString(this.c) + "." +
					Integer.toString(this.d);
			System.out.println(str);
		}
		
		public void add() {
			boolean flag = false;
			
			if (d < 255) 
				d++;
			else {
				d = 0;
				flag = true;
			}
			
			if (flag)
				if (c < 255) {
					c++;
					flag = false;
				} else {
					c = 0;
					flag = true ;
				}

			if (flag)
				if (b < 255) {
					b++;
					flag = false;
				} else {
					b = 0;
					flag = true;
				}
			
			if (flag)
				if (a < 255) {
					a++;
					flag = false;
				} else {
					a = 255;
				}
		}

		public void convert(String str){
			
			String buffer = "";
			
			int counter = 0;
			
			for (int i = 0; i < str.length(); i++){
				if (str.charAt(i) == '.') {
					switch (counter) {
					case 0:
						this.a = Integer.parseInt(buffer);
						break;
					case 1:
						this.b = Integer.parseInt(buffer);
						break;
					case 2:
						this.c = Integer.parseInt(buffer);
						break;
					}
					
					counter++;
					buffer = "";
				} else {
					buffer += str.charAt(i);
				};
			}
			
			this.d = Integer.parseInt(buffer);
		}
		
 		public ArrayList<IPAddress> getAddressRange(IPAddress beginIP, IPAddress endIP) throws CloneNotSupportedException {
			ArrayList<IPAddress> mainList = new ArrayList<IPAddress>();
			
			IPAddress currentIP = null;
			
			currentIP =  (IPAddress) beginIP.clone();
			
			mainList.add(beginIP);
			
			while (!endIP.equals(currentIP)){
				currentIP.add();
				mainList.add((IPAddress) currentIP.clone());
			}
			
			return mainList;
		}
	}
	
	public void Run(String prm1, String prm2) throws CloneNotSupportedException{
        IPAddress IP = new IPAddress();
        
        if ((new IPAddress(prm2)).gt(new IPAddress(prm1))) {
			System.out.println( 
	        		            "Parametr N1 = " + prm1 + 
	        		            " Parametr N2 = " + prm2 + "\n"
	        		          );
			
			for (IPAddress item : IP.getAddressRange(
					new IPAddress(prm1),
					new IPAddress(prm2))
				) {
	        	item.printIPToConsole();
	        }
        } else {
			System.out.println( 
		            "Parametr N2 = " + prm2 + 
		            " <= Parametr N1 = " + prm1 + "\n" +
		            "The program can't complete \n"		
		          );
        	
        }
	}
	
	
	public static void main( String[] args ) throws CloneNotSupportedException
    {
		App basic = new App();
		basic.Run(args[0], args[1]);
    }
}