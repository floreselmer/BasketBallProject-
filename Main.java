package connector;
import java.sql.*;
import java.util.Scanner;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybasketball", "root", "Macy1234!");
			Statement stmt = con.createStatement();
			File F = new File("teamentityspacetest.txt");
			Scanner in = new Scanner(F);
			File R = new File("players.txt");
			Scanner sc = new Scanner(R);
			File T = new File("salary.txt");
			Scanner sa = new Scanner(T);
			File S = new File("playerstats.txt");
			Scanner ps = new Scanner(S);
			
		/*	while (in.hasNext()) // team table
			{
				String s = in.nextLine();
	            int start = 0;
	            int n2 = s.indexOf('_', start);
	            String Tname = s.substring(0, n2);
	            int n3 = s.indexOf('_', n2 + 1);
	            String Coach = s.substring (n2 + 1, n3);
	            int n4 = s.indexOf('_', n3 + 1);
	            String City = s.substring(n3 + 1, n4);
	            int n5 = s.indexOf("_", + n4 + 1);
	            String Arena = s.substring(n4 + 1, n5);  
	            String teamid = s.substring(n5 + 1);
	            //int teamid = Integer.parseInt(stringteamid);
				String sql = "INSERT INTO team (Tname, Coach, City, Arena, teamid) VALUES ("+"\""+Tname+"\""+","+"\""+Coach+"\""+","+"\"" +City+ "\""+","+"\"" + Arena+ "\""+","+"\""+teamid +"\""+")"; 
				stmt.execute(sql);
			}	*/
			/*while (sc.hasNext()) // player table
			{
				String s = sc.nextLine();
	            int start = 0;
	            int n2 = s.indexOf('_', start);
	            String Pname = s.substring(0, n2);
	            int n3 = s.indexOf('_', n2 + 1);
	            String agestring = s.substring (n2 + 1, n3);
	            int age = Integer.parseInt(agestring);
	            int n4 = s.indexOf('_', n3 + 1);
	            String height = s.substring(n3 + 1, n4);
	            int n5 = s.indexOf('_', n4 + 1);
	            String weight = s.substring(n4 + 1, n5);
	            int n6 = s.indexOf('_', n5 + 1);
	            String college = s.substring(n5 + 1, n6);
	            int n7 = s.indexOf('_', n6 + 1);
	            String pid = s.substring(n6 + 1, n7);
	            String tid = s.substring(n7 + 1);
	            String playertable = "INSERT INTO player (Pname, age, height, weight, college, playerid, teamid) VALUES ("+"\""+Pname+"\""+","+"\""+age+"\""+","+"\"" +height+ "\""+","+"\"" + weight+ "\""+","+"\"" + college+ "\""+","+"\""+ pid + "\""+","+"\""+ tid +"\""+")";
	            stmt.execute(playertable);
			}	*/
			
		/*	while (sa.hasNext()) //salary table
			{
				String s = sa.nextLine();
	            int start = 0;
	            int n2 = s.indexOf('_', start);
	            String GM = s.substring(0, n2);
	            int n3 = s.indexOf('_', n2 + 1);
	            String year = s.substring (n2 + 1, n3);
	            int n4 = s.indexOf('_', n3 + 1);
	            String capstring = s.substring(n3 + 1, n4);
	            int cap = Integer.parseInt(capstring);
	            String Teamid = s.substring(n4 + 1);
	            //int Teamid = Integer.parseInt(stringteamid);
	            String salarytable = "INSERT INTO salary (GM, startyear, cap, Teamid) VALUES ("+"\""+GM+"\""+","+"\""+year+"\""+","+"\"" +cap+"\""+","+"\""+ Teamid +"\""+")";
	            stmt.execute(salarytable);
			} */
			
		/*	while (ps.hasNext()) // player stats tables
			{
				String Pid = ps.next();
				//int playernumber = Integer.parseInt(playernum);
				double ppg = ps.nextDouble();
				double rpg = ps.nextDouble();
				double apg = ps.nextDouble();
				double bpg = ps.nextDouble();
				double spg = ps.nextDouble();
				String playerstatstable = "INSERT INTO playerstats (playerid, ppg, rpg, apg, bpg, spg) VALUES ("+"\""+Pid+"\""+","+"\""+ppg+"\""+","+"\"" +rpg+ "\""+","+"\""+apg+ "\""+","+"\"" +bpg+ "\""+"," +"\""+spg + "\""+")";
				stmt.execute(playerstatstable);
			} */
			Boolean test=true;
			while(test==true) {
				Scanner input=new Scanner(System.in);
				System.out.println();
				System.out.println("Hello, which query would you like to run? Press numbers 1-15 to run a query. Enter any number greater than 15 to exit.");
				System.out.println();
				
				int response=input.nextInt();
				
			if(response==1)
			{
				Statement b = con.createStatement();	// Query #1
				ResultSet ba =  b.executeQuery("select Player_Name, ppg, rpg from playerstats ");
				System.out.println("1. Find the player(s) who score at least 10 PPG, have at least 10 RPG.");
						while(ba.next()) 
						{
							String PPName = ba.getString("Player_Name");
							double TPGG = ba.getDouble("ppg");
							double TRPG = ba.getDouble("rpg");
	         
						if(TPGG >= 10.0 && TRPG >= 10.0)
						{
	         
							System.out.println(PPName);
						}	
				
						}
			}
			
			if(response==2)
			{
	       Statement c = con.createStatement();	//Query #2
	        ResultSet bc =  c.executeQuery("select Player_Name, bpg from playerstats");
	        System.out.println("2. Find the name of players who averaged at least 1 BPG (blocks per game).");
	        	while(bc.next())
	        	{
	        		String CPName = bc.getString("Player_Name");
	        		double CBG = bc.getDouble("bpg");
	                   
	               if(CBG >= 1)
	               {
	               
	                 System.out.println(CPName);
	               }
	        	}  
			}
			
			if(response==3)
			{
			Statement d = con.createStatement();	//Query #3
	        ResultSet da =  d.executeQuery("select age, teamname from player");
	       
	        int totalage = 0;
	        System.out.println("3. Find the AVERAGE age of players who play for the Chicago Bulls.");
	         while(da.next())
	         {
	        	 int age = da.getInt("age");
		         String TName = da.getString("teamname");
		         
		         
	            if(TName.contains("Chicago Bulls"))
	            {
	            	totalage = totalage + age;
	            }
	            
	         }
	         totalage = totalage / 10;
	        System.out.println(totalage);	
			}
			
			if(response==4)
			{
			Statement e = con.createStatement();	//Query #4
	        ResultSet ea =  e.executeQuery("select Player_Name, ppg, age from playerstats");
	        System.out.println("4. Find the name of players under 25 years old who score at least 20 ppg.");
	        while(ea.next())
	        {
	        String EPName = ea.getString("Player_Name");
		    int EAge = ea.getInt("age");
		    double EPPG = ea.getDouble("PPG");
		        if(EPPG >=20 && EAge<= 25)
		        {
		         System.out.println(EPName);
		        
		        }
	        }
			}
			
			if(response==5)
			{
			Statement f = con.createStatement(); //Query #5
	        ResultSet fa =  f.executeQuery("select TeamName, cap from Salary");
	        String fname = "";
	        int small = 140000000;
	        System.out.println("5. Find the name of the team who has the smallest cap.");
	        while(fa.next())
	        {
	        	String FTName = fa.getString("TeamName");
		        int FCap = fa.getInt("cap");
		        if (FCap < small)
		        {
		        	small = FCap;
		        	fname = FTName;
		        }
		        
		        
	        }
	        System.out.println(fname);	
			}
			
			if(response==6)
			{
			Statement f = con.createStatement(); //Query #6
	        ResultSet fa =  f.executeQuery("select TeamName, cap from Salary");
	        String fname = "";
	        int big = 110000000;
	        System.out.println("6. Find the name of the team who has the largest cap.");
	        while(fa.next())
	        {
	        	String FTName = fa.getString("TeamName");
		        int FCap = fa.getInt("cap");
		        if (FCap > big)
		        {
		        	big = FCap;
		        	fname = FTName;
		        }
		        
		        
	        }
	        System.out.println(fname);	
			}
			
			if(response==7)
			{
			 Statement h = con.createStatement();		//Query #7
	        ResultSet ha =  h.executeQuery("select Player_Name, apg from playerstats");
	        
	        System.out.println("7. Find the name of the players who average over 5 assists per game.");
	            while(ha.next())
	            {
	            	String HPName = ha.getString("Player_Name");
	    	        double HAPG = ha.getDouble("apg");
	    	        
	               if(HAPG > 5)
	               {
	                     System.out.println(HPName);
	               }
	            
	            }	
			}
			
			
			if(response==8)
			{
			 Statement j = con.createStatement(); // Query #8
	        ResultSet ja = j.executeQuery("select Coach, City from team");
	        System.out.println("8. Find the coach who coaches in Dallas.");
	        while(ja.next())
	        {
	        	String Jcoach = ja.getString("Coach");
		        String Jcity = ja.getString("City");
		        
		        if (Jcity.contains("Dallas"))
		        {
		        	System.out.println(Jcoach);
		        }
	        }  
			}
			
			
			if(response==9)
			{
			Statement o = con.createStatement();	// Query #9
	        ResultSet ob =  o.executeQuery("select Pname, teamname from player");
	        System.out.println("9. Find the name of all the players who play on the Chicago Bulls.");
	        while (ob.next())
	        {
	        	String pname = ob.getString("Pname");
	        	String teamname = ob.getString("teamname");
	        	
	        	if (teamname.contains( "Chicago Bulls"))
	        	{
	        		System.out.println(pname);
	        	}
	        	
	        } 
			}
	        
			if(response==10)
			{
			 Statement c = con.createStatement(); //Query #10
	        ResultSet bc =  c.executeQuery("select spg, Player_Name, age from playerstats ");
	        System.out.println("10. Display the players name,age, and steals who have over 1.5 steals per game.");
	        while(bc.next())
	        {
	        	String CTName = bc.getString("Player_Name");
		        double CSPG =  bc.getDouble("spg");
		        int CAGE = bc.getInt("age");
		        
	        	if (CSPG > 1.5)
	        	{
	        		System.out.println(CTName + " " + CSPG + " " + CAGE);
	        	}
	        
	        }                                                       
			}
			
			if(response==11)
			{
			Statement n = con.createStatement();	//Query #11
	        ResultSet nb =  n.executeQuery("select Pname, height, weight, teamname from player");
	        System.out.println("11. Find the player name, height , and weight who play on the team LAKERS.");
	        while(nb.next())
	        {
	        	String pname = nb.getString("Pname");
	        	String height = nb.getString("height");
	        	String weight = nb.getString("weight");
	        	String tname = nb.getString("teamname");
	        	
	            if(tname.contains("Los Angeles Lakers"))
	            {
	                  System.out.println(pname + " " + height + " " + weight + " " + tname);
	            }        
	        }	
			}
				
			if(response==12)
			{	
			Statement z = con.createStatement();	//Query #12
	        ResultSet za =  z.executeQuery("select Pname, college, teamname from player");
	        System.out.println("12. Find the name of players and their teams from the players that played at UCLA.");
	        while(za.next())
	        {
	        	String pname = za.getString("Pname");
	        	String tname = za.getString("teamname");
	        	String college = za.getString("college");
	        	
	            if(college.contains("UCLA"))
	            {
	                  System.out.println(pname + " " + tname + " " + college);
	            }        
	        }	
			}
			
			if(response==13)
			{
			 Statement x = con.createStatement();	//Query #13
			ResultSet xa =  x.executeQuery("select GM, cap, teamname from salary");
			System.out.println("13. Get the name of teams and their GM with a cap greater than or equal to 125,000,000.");
			while (xa.next())
			{
				String gm = xa.getString("GM");
				int cap = xa.getInt("cap");
				String teamname = xa.getString("teamname");
				
				if (cap >= 125000000)
				{
					System.out.println(gm + " " + cap + " " + teamname);
				}
			}	
			}
			
			if(response==14)
			{
			Statement y = con.createStatement();	//Query #14
			ResultSet ya =  y.executeQuery("select weight, teamname from player");
			int totalweight = 0;
			System.out.println("14. Find the average weight of the New Orleans Pelicans.");
			while (ya.next())
			{
				String rweight = ya.getString("weight");
				int weight = Integer.parseInt(rweight);
				String tname = ya.getString("teamname");
				
				if (tname.contains("New Orleans Pelicans"))
				{
					totalweight = totalweight + weight;
				}
				
			}
			totalweight = totalweight / 10;
			System.out.println("Average weight of New Orleans Pelicans is " + totalweight + " pounds"); 
			}
			
			if(response==15)
			{
			Statement v = con.createStatement();	//Query #15
			ResultSet va =  v.executeQuery("select Player_Name, age, ppg from playerstats");
			System.out.println("15. Find the name of players and their age who has more than 28 ppg.");
			while (va.next())
			{
				String pname = va.getString("Player_Name");
				int age = va.getInt("age");
				double ppg = va.getDouble("ppg");
				
				if (ppg >= 28)
				{
					System.out.println(pname + " " + age + " " + ppg);
				}
			}	
			}	
			
			else if(response>15 || response <0){test=false;} 
			
			
			}
	        con.close();
			in.close();
			sc.close();
			sa.close();
			ps.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
