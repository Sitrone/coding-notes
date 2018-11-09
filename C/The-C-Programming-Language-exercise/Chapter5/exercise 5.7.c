/*
    Rewrite readlines to store lines in an array supplied by main.
*/

#include <string.h>

#define MAXLEN 1000     /* maxinum length of line */
#define MASTOR 5000     /* size of available storage space */

int geline(char *, int );

/* readlines: read input lines */
int readlines(char *lineptr, char *lineptor, int maxlines)
{
    int len, nlines;
	char line[MAXLEN];
	char *p = lineptor;
	char *linestop = linestor + MAXLEN;
	
	nlines = 0;
	while((len = geline(line, MAXLEN)) > 0)
	    if(nlines >= maxlines || p + len > lines )
		    return -1;
		else{
		    line[len - 1] = '\0';
			strcpy(p, line);
			lineptr[nlines++] = p;
			p += len;
		}
	return nlines;
}
