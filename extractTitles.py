# Extract titles of articles from Wikipedia API search json response

string = "Paste your json response here"
wordArray = string.split('"')
for i in range(len(wordArray)):
	if wordArray[i] == "title":
		if wordArray[i + 1] == ":":
			print(wordArray[i + 2])
