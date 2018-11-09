 #include <stdio.h>
 #include <string.h>
 
 #define MAXLINES 5000         /* max #lines to be sorted */

 char *lineptr[MAXLINES];      /* pointers to text line */
 
 int readlines(char *lineptr[MAXLINES], int nlines);
 void writelines(char *lineptr[MAXLINES], int nlines);
 
 void qsort(char *lineptr[], int left, int right);
 
 /* sort input line */
 main()
 {
     int nlines;               /* number of input lines read */
	 
	 if((nlines = readlines(lineptr,MAXLINES) >= 0)){
	    qsort(lineptr, 0, nlines - 1);
        writelines(lineptr, nlines);
        return 0;		
    }else{
	    printf("error: input too big to sort\n");
		return 1;
	}
 }
 
 #define MAXLIN 1000           /* max length of any input lines */

 int getline(char *s, int i);
 char *alloc(int);
 
/* readlines: read input lines */
int readlines(char *lineptr[], int maxlines)
{
  
    int len, nlines;
	char *p, line[MAXLIN];
	
	nlines=0;
	while((len = getline(line, MAXLIN)) > 0){
	    if (nlines >= maxlines || (p = alloc(len)) == NULL)
		    return -1;
		else{
		    line[len - 1] = '\0';        /* delete newline */
			strcpy(p, line);
			lineptr[nlines++] = p;
		}
	}
	return nlines;
}

/* writelines: write output lines */
void writelines(char *lineptr[MAXLINES], int nlines)
{
    while(nlines-- > 0)
	    printf("%s\n", *lineptr++);
}

 /* getline: read a line into line, and return length */
int getline(char *line, int lim)
{
    int c;
    char *bs = line;
	
	while (--lim > 0 && (c = getchar()) != EOF && c != '\n')
	    *line++ = c;
	if (c =='\n')
	    *line++ = c;
	*line = '\0';
	
	return line-bs;
}


/* qsort: sort v[left] ... v[right] increasing order */
void qsort(char *v[], int left, int right)
{
    int i, last;
	void swap(char *v[], int i, int j);
	
	if(left >= right)         /* do nothing if array contains */
	    return;
	swap(v, left, (left + right)/2);
	last = left;
	for(i = left + 1; i <= right; i++)
	    if(strcmp(v[i], v[left]) < 0)
		    swap(v, ++last, i);
	swap(v, left, last);
	qsort(v, left, last - 1);
	qsort(v, last + 1, right);
}

/* swap: interchange v[i] and v[j] */
void swap(char *v[], int i, int j)
{
    char *temp;
	
	temp = v[i];
	v[i] = v[j];
	v[j] = temp;
}
