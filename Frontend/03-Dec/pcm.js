
// DOM Event Handling
document.getElementById('btn').onclick = function(){
    var P = document.querySelector('.txt1').value;
    var C = document.querySelector('.txt2').value;
    var M = document.querySelector('.txt3').value;

    console.log(M,isNaN(M));

    if(P == "" ||C == "" ||M == ""){
        alert('Please Enter the Value');
    }
    else if(isNaN(P) || isNaN(C) || isNaN(M)){
        alert('Please Enter the Valid Value');
    }

    else{
        P = parseInt(P);
        C = parseFloat(C);
        M = Number(M);

        var total = P+C+M;
        var Per = (total / 300) * 100;
        
        console.log(total);
        console.log(Per);
        
        console.log(document.querySelector('#r1'));
        console.log(document.querySelector('#r2'));

        Per = Per.toFixed(2) + '%';
        
        document.querySelector('#r1').innerHTML = total;
        document.querySelector('#r2').innerHTML = Per




        // Graph
        Highcharts.chart('container', {
            chart: {
                type: 'pie'
            },
            title: {
                text: 'PCM Composition'
            },
            tooltip: {
                valueSuffix: '%'
            },
            subtitle: {
                text:
                'Source:<a href="https://www.mdpi.com/2072-6643/11/3/684/htm" target="_default">MDPI</a>'
            },
            plotOptions: {
                series: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: [{
                        enabled: true,
                        distance: 20
                    }, {
                        enabled: true,
                        distance: -40,
                        format: '{point.percentage:.1f}%',
                        style: {
                            fontSize: '1.2em',
                            textOutline: 'none',
                            opacity: 0.7
                        },
                        filter: {
                            operator: '>',
                            property: 'percentage',
                            value: 10
                        }
                    }]
                }
            },
            series: [
                {
                    name: 'Percentage',
                    colorByPoint: true,
                    data: [
                        {
                            name: 'Physics',
                            y: P
                        },
                        {
                            name: 'Chemistry',
                            y: C
                        },
                        {
                            name: 'Math',
                            y: M
                        },
                    ]
                }
            ]
        });

        

    }
}
