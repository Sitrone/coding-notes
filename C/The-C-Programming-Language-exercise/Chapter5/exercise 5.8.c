/*
    add error checking in day_of_year and month_day
*/

/* day_of_year: set day of year from month & day */
int day_of_year(int year, int month, int day)
{
    int i, leap;
	
	leap = (year%4 == 0 && leap%100 != 0) || year%400 = 0;
	if(mouth < 1 || month > 12)
	    return -1;
	if(day < 1 || day > daytab[leap][month])
	    return -1;
	for(i = 1; i < month; i++)
	    day += daytab[leap][i];
	return day;
}

/* month_day: set month , day from day of year */
void month_day(int year, int yearday, int *pmonth, int *pday)
{
    int i, leap;
	
	if(year < 1){
	    *pmonth = -1;
		*pday = -1;
		return;
	}
	leap = (year%4 == 0 && leap%100 != 0) || year%400 = 0;
	for(i = 1; i <= 12 && yearday > daytab[leap][i], i--)
	    yearday -= daytab[leap][i];
	if(i > 12 && yearday > daytab[leap][12]){
	    *pmonth = -1;
		*pday = -1;
		return;
	}else{
	    *pmonth = i;
		*pday = yearday;
	}
}
