<html>
    <head>
        <link rel="stylesheet" href="styles/style.css">
        <script type="text/javascript">
            var socket;
            var hasSelected = false;
            function connect(){
                socket = new WebSocket("ws://localhost:8080/ChessWebApp/chess");
                socket.onmessage = onMessage;
            }
            function onMessage(event){
                let obj = JSON.parse(event.data);
                console.log(obj);
                clearTable();
                for(let i = 0; i<obj.length; i++){
                    let divID = "field"+obj[i].row+obj[i].column;
                    let currentDiv = document.getElementById(divID);
                    if(obj[i].selected){
                        currentDiv.top -= 5;
                        currentDiv.left -= 5;
                        currentDiv.style.border = "5px solid red";
                    }
                    else{
                        currentDiv.top += 5;
                        currentDiv.left += 5;
                        currentDiv.style.border = "none";
                    }
                    let inner = "<img src='figureImages/";
                    if(obj[i].figure == "k" || obj[i].figure == "K"){
                        if(obj[i].white){
                            inner += "knight_white.png' />";
                        }
                        else if(obj[i].black){
                            inner += "knight_black.png' />";
                        }
                    }
                    else if(obj[i].figure == "r" || obj[i].figure == "R"){
                         if(obj[i].white){
                             inner += "rook_white.png' />";
                         }
                         else if(obj[i].black){
                             inner += "rook_black.png' />";
                         }
                     }
                    else if(obj[i].figure == "b" || obj[i].figure == "B"){
                         if(obj[i].white){
                             inner += "bishop_white.png' />";
                         }
                         else if(obj[i].black){
                             inner += "bishop_black.png' />";
                         }
                     }
                    else if(obj[i].figure == "q" || obj[i].figure == "Q"){
                          if(obj[i].white){
                              inner += "queen_white.png' />";
                          }
                          else if(obj[i].black){
                              inner += "queen_black.png' />";
                          }
                      }
                    else if(obj[i].figure == "c" || obj[i].figure == "C"){
                         if(obj[i].white){
                             inner += "king_white.png' />";
                         }
                         else if(obj[i].black){
                             inner += "king_black.png' />";
                         }
                    }
                    else if(obj[i].figure == "p" || obj[i].figure == "P"){
                         if(obj[i].white){
                             inner += "pawn_white.png' />";
                         }
                         else if(obj[i].black){
                             inner += "pawn_black.png' />";
                         }
                    }
                    else{
                        document.getElementById(divID).innerHTML = obj[i].figure;
                    }
                    currentDiv.innerHTML = inner;
                }
            }
            function clearTable(){
                for(let i = 0; i<8; i++){
                    for(let k = 0; k<8; k++){
                        let divID = "field"+i+k;
                        document.getElementById(divID).innerHTML = "";
                        document.getElementById(divID).border = null;
                    }
                }
            }
            function sendMessage(){
                let txtMessage = document.getElementById("message");
                let text = txtMessage.value;
                socket.send(text);
            }
            function sendSelectMessage(row, column){
                socket.send("select "+row+" "+column);
            }
            function sendMoveMessage(row,  column){
                socket.send("move "+row+" "+column);
            }
            function clickField(row, column){
                let divField = document.getElementById("field"+row+column);
                if(hasSelected){
                    sendMoveMessage(row, column);
                    hasSelected = false;
                    return;
                }
                sendSelectMessage(row, column);
                hasSelected = true;
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
                        divs += "' onclick='clickField("+i+", "+j+");'></div>";

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
