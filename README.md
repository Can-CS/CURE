  Code duplications in software systems make it difficult to maintain the software, leading to unwanted file size increases, errors, or performance issues. 
The main goal of this project is to detect, analyze, and eliminate these code duplications.
We will employ code clone detection tools and code dependency analysis tools such as NiCad Clone Detector, 
to detect code sections that can be extracted as methods that can be called from multiple locations. 

Our goal is to automatically refactor code bases to eliminate code duplication and as such to improve maintainability.
The main development tool will be IntelliJ using Java and Maven/Gradle. We will be using Git for version control and project management.
Also, code analysis libraries such as Spoon or JavaParser will be used during the development process of this tool. 

With the help of these tools, models like AST tree or data dependency graph will emerge. 
Duplicate parts will be eliminated by extracting them as methods by using these models. 

It will be shown that code clones can be found using clone detection tools and that methods can be extracted for some different cases. 
Also, it will be shown that these clones can be eliminated with the help of a simple system.
