/*
    rewrite day_of_year and month_day instead of indexing
*/

static char daytab[]{
        {0,31,28,31,30,31,30,31,31,30,31,30,31},
	{0,31,29,31,30,31,30,31,31,30,31,30,31}
}

/* day_of_year: set day of year from month & day */
int day_of_year(int year, int month, int day)
{
        int leap;
	char *p;
	
	leap = (year%4 == 0 && leap%100 != 0) || year%400 = 0;
	if(mouth < 1 || month > 12)                 /* check mouth */
	    return -1;
	if(day < 1 || day > daytab[leap][month])    /* check day */
	    return -1;
	p = daytab[leap];
	while(--mouth)
	    day += *++p;
	return day;
}

/* month_day: set month , day from day of year */
void month_day(int year, int yearday, int *pmonth, int *pday)
{
        int leap;
	char *p;
	
	if(year < 1){
	        *pmonth = -1;
		*pday = -1;
		return;
	}
	leap = (year%4 == 0 && leap%100 != 0) || year%400 = 0;
	p = daytab[leap];
	while(yearday > *++p)
	        yearday -= *p;
	if((p - *(daytab + leap)) > 12 && yearday > daytab[leap][12]){
	        *pmonth = -1;
		*pday = -1;
		return;
	}else{
	        *pmonth = p - *(daytab + leap);
		*pday = yearday;
	}
}
