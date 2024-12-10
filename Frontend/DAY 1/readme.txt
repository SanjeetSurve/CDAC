<tag> ...........</tag>         --------> Tags

<h1>..........</h1>             --------> Header(once can be used)


<p>............</p>             ---------> Paragraph

<style>
    h1{
        background-color: aqua;
        text-align = centre;
    }
    p{
        font-size: 40px;
        border: solid;

    }
</style>            ---------> CSS

<tag attribute>......</tag>

When we have multiple same tags then to segrigate we use Id's 

<h1 id = "p2">..........</h1> 
<h1 id = "p3">..........</h1> 
<h1>..........</h1> 
<h1>..........</h1> 
<h1>..........</h1> 

while we are using the Id we should start with *#id_name*

<style>     
    #p2{
        background-color: aqua;
    }
</style>     

there are 3 types for creating the background-color using these types:

1.  background-color: rgb(0,0,0);
2.  background-color: #f1c2d4;


Class:

we are using class attribute then we use
---.p2 ------->     Class
---#p2  ------->    ID

in classes we can have multiple classes inside it where as the id can contain only and single id of itself 

margin = used to shift the structure from its original co-ordinates

padding = space within the border


unpaired element:
    1. <img src="" alt='instead of image this will show'>
        float: "left";
        for getting like shooping websites contains in row

Shortcuts:

    div>+img+h2+p>button        
    .class_name>img+h2+p>button
    h1.p1$*4    (to get 4 h1 using classes)
    .div$*4     (for getting multiple <div> we can give anyname .name$*4)


************************************************************

here we can see that there are 2 style type inline, internal css we use inline there is gray but the color is the aquamarine because we are using the 
!important
in the style tag 


<h1 style="background-color: gray; text-align: center;" >HELLO WORLD!!</h1>


    <style>
        h1{
            background-color: aquamarine !important;
        }
    </style>
************************************************************