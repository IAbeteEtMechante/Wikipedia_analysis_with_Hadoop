Link for Wikipedia API search:
https://en.wikipedia.org/w/api.php?action=query&list=search&srsearch=intitle:coronavirus&srlimit=500&utf8=&format=json&srprop=%22%22

Parameters:

srsearch (Compulsory): the keyword to search for.
	Use %20 as space. This only work for single word search. If you input Donald%20Trump, the API will search for "Donald" and "Trump".
	Use intitle:keyword to search for keyword in title only (default is to search in articles' text).

srlimit (Optional): number of results to return.
	Default: 10.
	Min: 0.
	Max: 500.

srprop (Optional): search properties.
	Since I only need to get the title, I used %22%22 (which stands for "") to remove unwanted properties.

You can look for more parameters here:
https://www.mediawiki.org/wiki/API:Search
