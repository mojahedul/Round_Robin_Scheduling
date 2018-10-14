package round_robin_scheduling_requirements;

import java.util.LinkedList;

public class Round_Robin_Scheduling_Requirements {
	
	int process_Number;
	int[] burst_Time;
	int[] process_OrderQueue;
	int[] waiting_Time;
	int[] turnAround_Time;
	int priority[];
	int avgWaiting_Time;
	int avgTurnAround_Time;
	//int sum_Of_AvgWaitingTime = 0;
	int sum_Of_WaitingTime = 0;
	int index = 0;
	int max_Time = 5;
	int sum_Of_Burst_Time = 0;
	int counter_Process = 0;
	
	LinkedList<Integer> list_Object = new LinkedList<Integer>();
	LinkedList<Integer> list_Waiting_Time = new LinkedList<Integer>();
	LinkedList<Integer> list_Counter_Process = new LinkedList<Integer>();
	LinkedList<Integer> list_Ready_Queue = new LinkedList<Integer>();
	LinkedList<Integer> list_Burst_Time = new LinkedList<Integer>();
	
	public Round_Robin_Scheduling_Requirements(int process_Number2, int[] burst_Time2, int[] process_OrderQueue2)
	{
		process_Number = process_Number2;
		
		burst_Time = burst_Time2;
		
		process_OrderQueue = process_OrderQueue2;
		
		
	}
	
	
	void Order_Prioritization()
	{
		int bigger_Than_MaxTime = 0;
		int[] Tracking_bigger_Than_MaxTime;
		int step = 0;
		int max_Process_Loop = process_Number;
		
		for(int i = 0; i < process_Number; i++)
		{
			if(burst_Time[i] > 5)
			{
				step = burst_Time[i] / max_Time;
				
				max_Process_Loop = max_Process_Loop + (step+1);
				
				++bigger_Than_MaxTime;
			}
			
			
			list_Burst_Time.addLast( burst_Time[i] );
			
			list_Ready_Queue.addLast( burst_Time[i] );
			
			System.out.println( list_Ready_Queue.get(i) );
		}
		
		;
		
		
		//Array definition & Limit
		Tracking_bigger_Than_MaxTime = new int[max_Process_Loop];
		
		
//		for(int i = 0; i < process_Number; i++)
//		{
//			
//		}
		
		
//		for( int i = 0; i< process_Number; i++)
//		{
////			
//			
//			if( list_Ready_Queue.get(i) > 5)
//			{
//				int temp = list_Ready_Queue.get(i) - 5;
//				
//				list_Ready_Queue.set(i, temp);
//			}
//
//			list_Counter_Process.addLast(i+1);
//				
//		} //1st Outer for( int i = 0; i< process_Number; i++) condition;
			
			
		while( list_Ready_Queue.size() != 0 )
		{
			int check = 0;
			int flag = 0;
			int counter = 0;
			
			System.out.println("list_Ready_Queue: " + list_Ready_Queue.size() );
			
			for(int j = 0; j < process_Number; j++)
			{
//				check = 0;
				
				if( list_Ready_Queue.size() == 0 )
					break;
				
				
				if( (list_Ready_Queue.get(0)) > 5)
				{
					int temp2 = 0;
					int temp4 = 0;
					int temp5 = 0;
					
					temp5 = list_Ready_Queue.get(0);
					temp2 = temp5 - 5;
					
					if( temp2 < 0)
					{
						temp2 = temp2 * (-1);
					}
					else if(temp2 >= 0)
					{
						temp2 = temp2 * (1);
					}
					
//					check = j;
					
					temp4 = list_Burst_Time.indexOf(temp5);
					
					list_Burst_Time.set(temp4, temp2);
					list_Ready_Queue.addLast(temp2);
					list_Ready_Queue.removeFirst();
					
					int temp3 = list_Burst_Time.indexOf(temp2);
					
					System.out.println("J: " + j);
					System.out.println("Index: " + temp3);
					System.out.println(">5+list_Ready_Queue: " + list_Ready_Queue);
					System.out.println(">5+list_Burst_Time: " + list_Burst_Time);
					
					list_Counter_Process.addLast(temp3 + 1);
					
//					Tracking_bigger_Than_MaxTime[j] = check;
					
//					list_Ready_Queue.addLast(temp2);
					
//					if(temp2 <= 5)
//					{
//						list_Ready_Queue.set(j, 0);
//					}
					
					
					
					//Inner if() Condition 
//					if( Tracking_bigger_Than_MaxTime[j] > 0)
//					{
//						list_Counter_Process.addLast( Tracking_bigger_Than_MaxTime[j] + 1);
//					}
					
					flag = 0;
					
				}
				
				else if( list_Ready_Queue.get(0) <= 5 )
				{
//					if( list_Ready_Queue.size() != 0 )
					{
						int temp2 = 0;
						
						temp2 = list_Ready_Queue.get(0);
						
						
						
//						list_Ready_Queue.set(j, 0);
						
						list_Ready_Queue.removeFirst();
						
						int temp3 = list_Burst_Time.indexOf(temp2);
						
						list_Counter_Process.addLast(temp3 + 1);
						
						System.out.println("J: " + j);
						System.out.println("Index: " + temp3);
						System.out.println("<=5-list_Ready_Queue: " + list_Ready_Queue);
						
//						list_Counter_Process.addLast( j+1 );
					}
				
//					else
//					{
//						System.out.println("OOPS !! Something went wrong.. Error 405");
//						//break;
//					}
					
				} //End of else condition;
				
				
//				else if( list_Ready_Queue.get(0) == 0 )
//				{
//					list_Ready_Queue.removeFirst();
//				}
				
				System.out.println("F " + list_Counter_Process);
				
				
				
				
			} //End of for(int j = 0; j < process_Number; j++);
			

			for(int k = 0; k < list_Ready_Queue.size(); k++ )
			{
				if( list_Ready_Queue.get(k) == 0)
				{
					++counter;
				}

			}
			
			if(counter == process_Number)
			{
				while( list_Ready_Queue.size() != 0 )
				{
					list_Ready_Queue.removeFirst();
				}
//				break;
			}
			
		} //while( list_Ready_Queue.size() != 0 ) Scope;
		
		
	} //End of void Order_Prioritization();
	//-----------------------------------------------
	
	
	public void Grant_Chart()
	{
		Order_Prioritization();
		
		for( int i = 0; i< process_Number; i++)
		{
			list_Object.add( burst_Time[i] );
		}
		
		
		while( list_Object.size() != 0 )
		{
			
//			System.out.printf("PPP%d", list_Counter_Process.get(counter_Process));
			
			if( list_Object.get(index) <= max_Time )
			{
				sum_Of_Burst_Time = sum_Of_Burst_Time + list_Object.get(index);
				
				
				System.out.printf("P%d", list_Counter_Process.get(counter_Process) );
				for(int i = 0; i < sum_Of_Burst_Time; i++)
				{
					System.out.print(".");
				}
				++counter_Process;
				
				list_Waiting_Time.add(sum_Of_Burst_Time);
				
				list_Object.removeFirst();
				
			} //End of if( list_Object.get(index) <= max_Time );
			
			
			else if( list_Object.get(index) > max_Time )
			{
				sum_Of_Burst_Time = sum_Of_Burst_Time + max_Time;
				
				int temp = list_Object.get(index) - 5;
				
				list_Object.addLast(temp);
				
				list_Object.removeFirst();
				
				System.out.printf("P%d", list_Counter_Process.get(counter_Process) );
				for(int i = 0; i < sum_Of_Burst_Time; i++)
				{
					System.out.print(".");
				}
				++counter_Process;
				
				if( counter_Process > list_Counter_Process.size() )
				{
					System.out.println("OOPS !! Something  went wrong..!!");
					break;
				}
				
				list_Waiting_Time.add(sum_Of_Burst_Time);
				
			} //End of else if( list_Object.get(index) > max_Time );
			
			
			else
			{
				System.out.println("OOPS !!! Something is wrong...");
			}
			
			
			
		} //End of while( list_Object.size() != 0 );
		
	} //End of public void Grant_Chart();
	
	
	
	
	public void Times()
	{
		int temp=1;
		int index = 0;
		int counter_AvgWaiting;
	
		//int sum_Of_AvgWaitingTime = 0;
		int sum_Of_AvgTurnAroundTime;
		
		System.out.println("\n\nWaiting Time(s): ");
		
		waiting_Time = new int[process_Number+1];
		
		
		//Calculating plain Waiting Time
		for( int i = 0; i < list_Waiting_Time.size(); i++ )
		{
			
			sum_Of_WaitingTime = sum_Of_WaitingTime + list_Waiting_Time.get(i);
			
		} //End of Outer For();
		
		

		avgWaiting_Time = sum_Of_WaitingTime / process_Number;
		
		
		//Calculating Average TurnAround Time
		sum_Of_AvgTurnAroundTime = 0;
		for( int i = 1; i <= process_Number; i++ )
		{
			
			
			sum_Of_AvgTurnAroundTime = sum_Of_AvgTurnAroundTime + turnAround_Time[i];
		}
		
		avgTurnAround_Time = sum_Of_AvgTurnAroundTime / process_Number;
		
		
		
		//Printing all Time Data
		System.out.println("Waiting\tTurnaround\tAvg. Waiting\tAvg.Turn Around");
		for( int i = 0; i <= list_Waiting_Time.size(); i++ )
		{
			System.out.println(list_Waiting_Time.get(i) + "\t" + turnAround_Time[i]+ "\t\t" + avgWaiting_Time + "\t\t" + avgTurnAround_Time);
		}
		
	} //End of public void Waiting_Time();

} //End of public class Round_Robin_Scheduling_Requirements;
