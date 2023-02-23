<html>
    <head>
        <link rel="stylesheet" href="styles/style.css">
        <script type="text/javascript">
            var socket;
            function connect(){
                socket = new WebSocket("ws://localhost:8080/ChessWebApp/chess");
                socket.onmessage = onMessage;
            }
            function onMessage(event){
                let obj = JSON.parse(event.data);
                console.log(obj);
                for(let i = 0; i<obj.length; i++){
                    let divID = "field"+obj[i].row+obj[i].column;
                    document.getElementById(divID).innerHTML = obj[i].figure;
                }
            }
            function sendMessage(){
                let txtMessage = document.getElementById("message");
                let text = txtMessage.value;
                socket.send(text);
            }
            function initTable(){
                let chessTable = document.getElementById("chessTable");
                console.log(chessTable);
                let divs = "";
                for(let i = 0; i<8; i++){
                    for(let j = 0; j<8; j++){
                        let x = j*80;
                        let y = i*80;
                        divs += "<div id='field";
                        divs += i;
                        divs += j+"' class='field ";
                        if((i % 2 == 0 && j % 2 == 0) || (i%2 == 1 && j%2 ==1)){
                            divs += "white";
                        }
                        else{
                            divs += "black";
                        }
                        divs += "'></div>";

                    }
                }
                chessTable.innerHTML = divs;
                for(let i = 0; i<8; i++){
                   for(let j = 0; j<8; j++){
                       let x = j*80;
                       let y = i*80;
                       let currentField = document.getElementById("field"+i+j);
                       currentField.style.top = y;
                       currentField.style.left = x;
                   }
                }
            }
            addEventListener("load", connect);
            addEventListener("load", initTable);
        </script>
    </head>
    <body>
        <div id="chessTable"></div>
        <input type="text" id="message"/>
        <button onclick="sendMessage();">send</button>
    </body>
</html>
