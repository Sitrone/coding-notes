/*  
    rewrite appropriate programs from eralier chapters and exercises
    with pointers instead of indexing.
*/

/* getline: read a line into s, and return length */
int getline(char *s; int lim)
{
    int c;
    int *is=s;
	
	while(--lim>0 && (c = getchar())!= EOF && c != '\n')
	    *s++ = c;
	if (c =='\n')
	    *s++ = c;
	*s = '\0';
	
	return s-is;
}

/* atoi: convert s to integer */
int atoi(char *s)
{
    int n, sign;
	
	for( ; isspace(*s); s++)               /* skip white space */
	    ；
	sign = (*s == '-')? -1 :1;
	if (*s == '+' || *s == '-')            /* skip sign	*/ 
	    s++;
	for( ; isdigit(*s); s++)
	    n = 10 * n + (*s - '0')
	
	return sign * n;
}

/* itoa: convert n to characters in s */
void itoa(int n, char *S)
{
    int sign;
	
	if((sign = n)< 0)
	    n = -n;
	
	do{
	    *s++ = n % 10 + '0';
	}while((n /= 10) > 0)
	if(sign < 0)
	    *s++ = '-';
	*s = '\0';
	
	reverse(s);
}

/* reverse : reverse string s in place */
void reverse(char *s)
{
    char *bs = s;
	
	while(*s++)
	    ;
	while(*bs++)
	    *s-- = *bs++
	 
    return s;	 
}

/* strindex: return index of t in s, -1 if none */
int strindex(char *S, char *t)
{
    char *bs = s;
	char *p, *r;
	
    for( ; *s != '\0'; s++){
	    for(p = s, r = t; *r != '\0' && *p == *r; p++, r++)
		    ;
		if(r > t && *r == '\0')
		    return s - b;
	}
	
	return -1;
}

/* atof: convert string s to double */
double atof(char *s)
{
    double val,power;
    int sign;
	
	for( ;isspace(*s); s++)
	    ;
	sign = (*s == '-') ? -1 : 1 
	
	if (*s == '-' || *s == '+')
	    s++;
	for(val = 0.0; isdigit(*s); s++)
	    val = 10.0 * val + (*s - '0');
	if(*s == '-')
	    s++;
	for(power=1.0; isdigit(*s); s++){
	    val = 10.0 * val + (*s - '0');
		power *= 10.0;
	}
	return sign * val / power;
}

/* getop : get next operator or numeric operand */
int getop(char *s)
{
    int c;
	
	while((*s++ = c = getchar()) == ' ' || c == '\t')
	    ;
	*s = '\0';
	if (!isdigit(c) && c != '.')
	    return c;
	if (isdigit(c))                  /* collect integer part */
	    while (isdigit(*++s = c = getch()))
		    ;
	if (c == '.')                    /* collect fraction part */
	    while (isdigit(*++s = c = getch()))
		    ;
	*s = '\0';
	if (c != EOF)
	    ungetch(c);
	return NUMBER;
}
