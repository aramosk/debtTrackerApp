<html>
<html>
<head>
    <meta name="layout" content="main" charset="utf-8"/>
    <title>Visualise debts in 3D surface plot</title>
    <style>
        body{
          font-family: sans;
          padding: 10px;
        }
        svg path{
          stroke: #000;
          stroke-width: 1px;
          stroke: rgba(0,0,0,0.2);
        }
        svg{
          border: 1px solid #DED8BF;
          background-color: #f4f4d9;
          width: 700px;
          height: 400px;
        }
        h1{
          font-weight: normal;
          margin: 0;
          padding-left: 5px;
          color: #53483e;
        }
        p{
          margin: 0;
          margin-bottom: 10px;
          padding-left: 5px;
          color: #917e6b;
        }
        ul{
          width: 200px;
          float: left;
          list-style-type: none;
          margin: 0;
          padding: 0;
          padding-right: 10px;
        }
        li{
          cursor: pointer;
          background-color: #c8ad93;
          padding: 10px;
          margin: 2px;
          color: #fff;
        }
    </style>
</head>
<body>
<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Visualise debts in 3D surface plot</h1>
    </section>
</div>
<script src="http://d3js.org/d3.v3.min.js"></script>
<asset:javascript src="surface3d.js"/>
<asset:javascript src="jquery-2.2.0.min.js"/>
<script>

function getAmount(x, y, data) {
     for(i=0; i< data.length; i++) {
         if(x==data[i].giver.id && y==data[i].receiver.id)
            return -data[i].amount;
     }
     return 0;
}

var debtsData=[];

$.getJSON('http://localhost:8080/debts', function (data) {

    for(var x=1; x<=data.length; x++){
        var f0=[];
        debtsData.push(f0);

        for(var y=1; y<=data.length; y++){
            f0.push(getAmount(x, y, data));
        }
    }

    console.log(debtsData);
});

function getDebts() {
    return debtsData;
}

  var yaw=0.5,pitch=0.5, width=700, height=400, drag=false;

  var surfaces=[
    {
      name: 'Debts',
      data: getDebts()
    }
  ];
  var selected=surfaces[0];

  var ul=d3.select('body')
           .append('ul');
  var svg=d3.select('body')
          .append('svg')
            .attr('height',height)
            .attr('width',width);

  var group = svg.append("g");

  var md=group.data([surfaces[0].data])
    .surface3D(width,height)
      .surfaceHeight(function(d){
        return d;
      }).surfaceColor(function(d){
        var c=d3.hsl((d+100), 0.6, 0.5).rgb();
        return "rgb("+parseInt(c.r)+","+parseInt(c.g)+","+parseInt(c.b)+")";
      });

  ul.selectAll('li')
    .data(surfaces)
      .enter().append('li')
        .html(function(d){
          return d.name
        }).on('mousedown',function(){
          md.data([d3.select(this).datum().data]).surface3D()
            .transition().duration(500)
            .surfaceHeight(function(d){
              return d;
            }).surfaceColor(function(d){
              var c=d3.hsl((d+100), 0.6, 0.5).rgb();
              return "rgb("+parseInt(c.r)+","+parseInt(c.g)+","+parseInt(c.b)+")";
            });
        });

  svg.on("mousedown",function(){
    drag=[d3.mouse(this),yaw,pitch];
  }).on("mouseup",function(){
    drag=false;
  }).on("mousemove",function(){
    if(drag){
      var mouse=d3.mouse(this);
      yaw=drag[1]-(mouse[0]-drag[0][0])/50;
      pitch=drag[2]+(mouse[1]-drag[0][1])/50;
      pitch=Math.max(-Math.PI/2,Math.min(Math.PI/2,pitch));
      md.turntable(yaw,pitch);
    }
  });

</script>

</body>
</html>