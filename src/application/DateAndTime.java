package application;

import java.util.Calendar;

public class DateAndTime
{
	private static String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	public static String getDateAndTime()
	{
		return java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime()).replace(",", "");
	}

	public static int parseYear(String date)
	{
		String[] values = date.split(" ");

		return Integer.parseInt(values[2]);
	}

	private static int monthToInt(String inputMonth)
	{
		for (int i = 0; i < months.length; i++)
		{
			if (months[i].equals(inputMonth))
			{
				return i;
			}
		}

		return -1;
	}

	public static boolean oneYearPassed(String start, String stop)
	{
		boolean returnValue = false;

		String[] startDate = start.split(" ");
		String[] stopDate = stop.split(" ");

		int startYear = Integer.parseInt(startDate[2]);
		int stopYear =  Integer.parseInt(stopDate[2]);

		int startMonth = monthToInt(startDate[0]);
		int stopMonth =  monthToInt(stopDate[0]);

		int startDay = Integer.parseInt(startDate[1]);
		int stopDay =  Integer.parseInt(stopDate[1]);

		if ((stopYear - startYear) > 1)
		{
			returnValue = true;
		}
		else if ((stopYear - startYear) > 0)
		{
			if (stopMonth > startMonth)
			{
				returnValue = true;
			}
			else if (stopMonth == startMonth)
			{
				if (stopDay > startDay)
				{
					returnValue = true;
				}
			}
		}

		return returnValue;
	}
}
