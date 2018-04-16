package given;

public class tester111 {


		public static String[] dumbmemory;
		
		public static void main(String[] args) {
			MemoryManagementSystem system;
			boolean result=true;
			
			int test=1;
			for(int i = 1;i<10;i++) { //main memory size
				for( int j = i+1;j<20;j++) { // second memory size
					boolean useLRU;
					
					for(int k=1;k<=2;k++) {
			
						useLRU = (k%2) == 0;
						system = new MemoryManagementSystem(i,j,useLRU);
						boolean passed;
						
						boolean passed1 = ApplyTest1(system,i,j,useLRU);
						boolean passed2 = ApplyTest1_2(system,i,j,useLRU);
						boolean passed3 = ApplyTest1_3(system,i,j,useLRU);
						
						
						passed = passed1 && passed2 && passed3;
						
						if(!passed)
							System.out.println("Test "+test+" Failed : mainMemorySize="+i+", seconderyMemorySize="+j +", useLRU="+useLRU);
						else
							System.out.println("Test "+test+" PASSED : mainMemorySize="+i+", seconderyMemorySize="+j +", useLRU="+useLRU);
					
							
						System.out.println("_________________________________________________________________________");
					
						result = result & passed;
						
						
						test++;
					}
					
				}
			}
			
			if(result)
				System.out.println("FIRST TEST PASSED , GOOD JOB !!! :)");
			else
				System.out.println("FIRST TEST FAILED , TRY HARDER YOU WILL DO IT !!");
			
			System.out.println("******************************************************************************************************");
			
			boolean result2 = ApplyTest2();
			if(result2)
				System.out.println("SECOND TEST PASSED , GOOD JOB !!! :)");
			else
				System.out.println("SECOND TEST FAILED , TRY HARDER YOU WILL DO IT !!");
			
			System.out.println("******************************************************************************************************");
			
			boolean result3 = ApplyTest3();
			if(result3)
				System.out.println("THIRD TEST PASSED , GOOD JOB !!! :)");
			else
				System.out.println("THIRD TEST FAILED , TRY HARDER YOU WILL DO IT !!");

			System.out.println("******************************************************************************************************");
			
			boolean result4 = ApplyTest4();
			if(result4)
				System.out.println("FOURTH TEST PASSED , GOOD JOB !!! :)");
			else
				System.out.println("FOURTH TEST FAILED , TRY HARDER YOU WILL DO IT !!");

			System.out.println("******************************************************************************************************");
			
			boolean compresult = ComponentsTest();
			if(compresult)
				System.out.println("Components TEST PASSED , GOOD JOB !!! :)");
			else
				System.out.println("Components TEST FAILED , TRY HARDER YOU WILL DO IT !!");

			System.out.println("******************************************************************************************************");
			
			boolean LRUresult = LRUTest();
			if(LRUresult)
				System.out.println("LRU TEST PASSED , GOOD JOB !!! :)");
			else
				System.out.println("LRU TEST FAILED , TRY HARDER YOU WILL DO IT !!");

			System.out.println("******************************************************************************************************");
			
			boolean FIFOresult = FIFOTest();
			if(FIFOresult)
				System.out.println("FIFO TEST PASSED , GOOD JOB !!! :)");
			else
				System.out.println("FIFO TEST FAILED , TRY HARDER YOU WILL DO IT !!");

			
		}
		
		private static boolean ApplyTest1(MemoryManagementSystem system,
				int mainMemorySize, int seconderyMemorySize,boolean useLRU) {
			
			
			dumbmemory = new String[seconderyMemorySize];
			
			
			
			int i;
			for(i=0;i<seconderyMemorySize;i++)
				writetoDumpMemory(i, "");
			
			for(i=0;i<mainMemorySize;i++) {
				writetoDumpMemory(i, "");
				try {
				system.write(i, 'a');
				}catch(Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			
			if(!ArrayEquals(dumbmemory, system.secondaryMemory)) {
				notifyError("Could be happened becuase you updating the second memory before it had been removed from main memory");
				return false;
			}
			int c=0;
			for(i=mainMemorySize;i<seconderyMemorySize;i++) {
				
				if(c>=mainMemorySize) {
					writetoDumpMemory(c,"b");
				}else {
					writetoDumpMemory(c,"a");
				}
				

				try {
					system.write(i, 'b');
				}catch(Exception e) {
					e.printStackTrace();
					notifyError("Error while writing key : "+ i );
					return false;
				}
				c++;
				
			}

			
				return CheckSystem(system);
			
		}

		//Assume that Test1 had been apply
		private static boolean ApplyTest1_2(MemoryManagementSystem system,
				int mainMemorySize, int seconderyMemorySize,boolean useLRU) {
			
			
			String curr = system.secondaryMemory[seconderyMemorySize - 1];	
			system.write(seconderyMemorySize-1,'c');
			String after = system.secondaryMemory[seconderyMemorySize - 1];		
			
			if(!curr.equals(after))
				return false;
			
			for(int i=0;i<seconderyMemorySize;i++) {
				try {
					system.read(i);
				}catch(Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			
			
			dumbmemory = new String[seconderyMemorySize];
			int i=0;
			for(i=0;i<mainMemorySize;i++)
				writetoDumpMemory(i, "a");
			
			for(i=mainMemorySize;i<seconderyMemorySize;i++)
				writetoDumpMemory(i, "b");
			
			writetoDumpMemory(seconderyMemorySize-1, "c");

			return CheckSystem(system);
		}
		
		//Assume that Test2 had been apply
		private static boolean ApplyTest1_3(MemoryManagementSystem system,
					int mainMemorySize, int seconderyMemorySize,boolean useLRU) {
				
				String curr = system.secondaryMemory[seconderyMemorySize - 1];
				
				
				try {
					system.write(seconderyMemorySize -1, 'f');
				}catch(Exception e) {
					notifyError("Error while writing key : " + (seconderyMemorySize - 1) );
					e.printStackTrace();
					return false;
				}
				String after = system.secondaryMemory[seconderyMemorySize - 1];
				
				if(!curr.equals(after)) {
					notifyError("Could be happened becuase you updating the second memory before it had been removed from main memory ");
					return false;
				}
				try {
					for(int j=0;j<mainMemorySize;j++)
						system.read(j);
				}catch(Exception e) {
					notifyError("Error while reading ");
					e.printStackTrace();
					return false;
				}
				
				String last = system.secondaryMemory[seconderyMemorySize - 1];
				
				
				if(last.equals(after)) {
					notifyError("Could be happened becuase you dont update the second memory after pulling the page from main memory ");
					return false;
				}
				return true;
			}
			
		
		private static boolean CheckSystem(MemoryManagementSystem system) {
				return ArrayEquals(system.secondaryMemory,dumbmemory);
		}

		private static void writetoDumpMemory(int index,String c) {
			
			
			if(dumbmemory[index] == null)
				dumbmemory[index] = "";
		
			
			dumbmemory[index] = dumbmemory[index] + c;
			
			
		}
		
		private static boolean ArrayEquals(String[] a1,String[] a2) {
			
			if(a1.length != a2.length)
				return false;
			
			for(int i=0;i<a1.length;i++)
				if(!(a1[i].equals(a2[i]))) {

					return false;
				}
		
			
			return true;
		}

		//LRU TEST
		private static boolean ApplyTest2() {
			dumbmemory = new String[20];
			
			for(int i=0;i<dumbmemory.length;i++){
				dumbmemory[i] = "";
			}
			
			MemoryManagementSystem system = new MemoryManagementSystem(5,20,true);
			system.write(0, 'Y');
			system.write(1, 'O');
			system.write(2, 'L');
			system.write(3, 'O');
			system.write(4, ' ');
			
		
			
			try{
				system.read(4);
				system.read(3);
				system.read(4);
				system.read(2);
				system.read(1);
				system.read(5);
			}catch (Exception e) {
				notifyError("error while reading @Test2");
				return false;
			}
			dumbmemory[0] = "Y";
			if(!ArrayEquals(dumbmemory, system.secondaryMemory)) {
				notifyError("Error @Test2, could be happened from not changing the page when main memory is full / unrwriting to the page");
				return false;
			}
			
			
			String r = system.read(0);
			if(!r.equals("Y")) {
				notifyError("error while reading @Test2");
				return false;
			}
			
			
			return true;
			
		}
		
		
		
		//FIFO TEST
			private static boolean ApplyTest3() {
				dumbmemory = new String[20];
				
				for(int i=0;i<dumbmemory.length;i++){
					dumbmemory[i] = "";
				}
				
				MemoryManagementSystem system = new MemoryManagementSystem(5,20,false);
				
			
				
				try{
					try {
					system.write(5,'H');
					}catch (Exception e) {
						notifyError("error while writing @Test3");
						return false;
					}
					system.read(6);
					system.read(7);
					system.read(8);
					system.read(9);
					system.read(10);
				}catch (Exception e) {
					notifyError("error while reading @Test3");
					return false;
				}
				
				dumbmemory[5] = "H";
				if(!ArrayEquals(dumbmemory, system.secondaryMemory)) {
					notifyError("Error @Test3, could be happened from not changing the page when main memory is full");
					
					System.out.println(system);
					
					return false;
				}
				
				
				String r = system.read(5);
				if(!r.equals("H")) {
					notifyError("error while reading @Test3");
					return false;
				}
				
				
				return true;
				
			}
		
			private static boolean ApplyTest4() {
				dumbmemory = new String[10];
				
				for(int i=0;i<dumbmemory.length;i++){
					dumbmemory[i] = "";
				}
				
				MemoryManagementSystem system = new MemoryManagementSystem(1,10,true);
				
			
				
				try{
					try {
						system.write(6, 'a');
						}catch (Exception e) {
							notifyError("error while writing @Test4");
							return false;
						}
					system.read(7);
					system.read(8);
					system.read(9);
					
					try {
						system.write(1, 'b');
						}catch (Exception e) {
							notifyError("error while writing @Test4");
							return false;
						}
					
					
				}catch (Exception e) {
					notifyError("error while reading @Test4");
					return false;
				}
				
				dumbmemory[6] = "a";
				if(!ArrayEquals(dumbmemory, system.secondaryMemory)) {
					notifyError("Error @Test4, could be happened from not changing the page when main memory is full");
					
					System.out.println(system);
					
					return false;
				}
				
			
				
				if(system.secondaryMemory[1].equals("b")) {
					notifyError("error while reading @Test4, could be happened from updating the page in the second memory before it's remove from main memory");
					return false;
				}
				
				
				return true;
				
			}
			
			private static boolean ComponentsTest() {
				
				MemoryManagementSystem system = new MemoryManagementSystem(1,2,true);
				String shouldBe = "MORTY";
				try {
					system.write(0, 'M');
					system.write(0, 'O');
					system.write(0, 'R');
					system.write(0, 'T');
					system.write(0, 'Y');
					
					String curr = system.secondaryMemory[0];
					
					if(!curr.equals("")) {
						notifyError("Failed at Component Test, happened from updating second memory before changing the page in the main memory");
						return false;
					}
					
				}catch (Exception e) {
					notifyError("Failed at Component Test, error while writing");
					e.printStackTrace();
					return false;
				}
				
				try {
					system.read(1);
					String curr = system.secondaryMemory[0];
					if(!curr.equals(shouldBe)) {
						notifyError("Failed at Component Test, happened from not updating second memory after changing the page in the main memory");
						return false;
					}
					
				}catch (Exception e) {
					notifyError("Failed at Component Test, error while reading");
					return false;
				}
				
				return true;
			}
			
			
			private static boolean LRUTest() {
				
				MemoryManagementSystem system = new MemoryManagementSystem(4,10,true);
				
				try {
					system.read(5);
					system.write(6,'a');
					system.write(7,'c');
					system.read(8);
					system.write(5, 'b');
					system.read(9);
				}catch (Exception e) {
					notifyError("Failed at LRU Test, error while reading");
					return false;
				}
				
				String curr = system.secondaryMemory[6];
				if(!curr.equals("a")) {
					if(system.secondaryMemory[5].equals("b")) {
						notifyError("Failed at LRU Test, happened from reordering the pages after wrting/reading to them (as an LRU Queue should do)");
					}else {
						notifyError("Failed at LRU Test, happened from not updating the second memory after changing the page in the main memory");
					}
					return false;
				}
				
				try {
					system.read(0);
				}catch (Exception e) {
					// TODO: handle exception
				}
				
			   curr = system.secondaryMemory[7];
				if(!curr.equals("c")) {
					if(system.secondaryMemory[5].equals("b")) {
						notifyError("Failed at LRU Test, happened from reordering the pages after wrting/reading to them (as an LRU Queue should do)");
					}else {
						notifyError("Failed at LRU Test, happened from not updating the second memory after changing the page in the main memory");
					}
					return false;
				}
				
				return true;
			}
			
			private static boolean FIFOTest() {
				
				MemoryManagementSystem system = new MemoryManagementSystem(4,10,false);
				
				try {
					system.read(5);
					system.write(6,'a');
					system.write(7,'c');
					system.read(8);
					system.write(5, 'b');
					system.read(9);
				}catch (Exception e) {
					notifyError("Failed at LRU Test, error while reading");
					return false;
				}
				
				String curr = system.secondaryMemory[5];
				if(!curr.equals("b")) {
					if(system.secondaryMemory[6].equals("a")) {
						notifyError("Failed at FIFO Test, happened from changing the pages in LRU method");
					}else {
						notifyError("Failed at FIFO Test, happened from not updating the second memory after changing the page in the main memory");
					}
					return false;
				}
				
				try {
					system.read(0);
				}catch (Exception e) {
					// TODO: handle exception
				}
				
			   curr = system.secondaryMemory[6];
				if(!curr.equals("a")) {
					notifyError("Failed at FIFO Test, happened from not updating the second memory after changing the page in the main memory");

					return false;
				}
				
				return true;
			}
			
		
		private static void notifyError(String error) {
			System.out.println("********************************************");
			System.out.println(error);
			System.out.println("********************************************");
		}


	}















