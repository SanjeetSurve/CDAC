const apiPath = 'https://fakestoreapi.com/products';


document.querySelector('#btn').onclick = function(){

    var xmlhttp = new XMLHttpRequest();
    console.log(xmlhttp);
    console.log(xmlhttp.readyState);
    
    xmlhttp.onreadystatechange = function(){
        console.log(xmlhttp.readyState, xmlhttp.status);

        if(xmlhttp.readyState == 4  &&  xmlhttp.status == 200){
            console.log(typeof xmlhttp.responseText);
            console.log(xmlhttp.responseText);

            var record = JSON.parse(xmlhttp.response);
            console.log(record);

            record && record.length > 0 && record.forEach((val) =>{
                console.log(val);

                var divTag = document.createElement('div');
                divTag.className = 'col-md-3';

                var imgTag = document.createElement('img');
                imgTag.src = val.image;
                imgTag.className = 'img-fluid';

                var h2Tag = document.createElement('h2');
                h2Tag.innerHTML = val.price;

                var h3Tag = document.createElement('p');
                h3Tag.innerHTML = val.title;

                divTag.append(imgTag, h2Tag, h3Tag)
                document.querySelector('.row').append(divTag);
                
            });
            
        }
    }
    
    xmlhttp.open('get', apiPath);
    xmlhttp.send();
}