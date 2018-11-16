/* 
 * The MIT License
 *
 * Copyright 2018 Pivotal Software, Inc..
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
var preguntas={};

var information=( function Information() {
 
    function getPreguntaSeleccionMultiple() {
        axios.get('/preguntas/psm').then(function (response) {
            this.preguntas=response.data;
            document.getElementById("enun").innerHTML = "Pregunta Seleccion : "+preguntas.enunciado;
            document.getElementById("respuesta").innerHTML = "Respuesta Seleccion : ";
            console.log(response.data)        
        })
        .catch(function (error) {
            console.log(error);
        })
    }
    function getPreguntasVerdaderoFalso(){
        axios.get('/preguntas/pvf').then(function (response) {
            this.preguntas=response.data;
            document.getElementById("enun").innerHTML = "Pregunta Falso o verdadero : "+preguntas.enunciado;
            document.getElementById("respuesta").innerHTML = "Respuesta F/V : ";
            console.log(response.data)
        })
        .catch(function (error) {
            console.log(error);
        });
    }
    
    
    function getPereguntasRellenar(){
        axios.get('/preguntas/pr').then(function (response) {
            this.preguntas=response.data;
            document.getElementById("enun").innerHTML = "Pregunta Rellenar : "+preguntas.enunciado;            
            document.getElementById("respuesta").innerHTML = "Respuesta Rellenar : ";

            console.log(response.data)
        })
        .catch(function (error) {
            console.log(error);
        });       
    }
    return {
        getPreguntaSeleccionMultiple:getPreguntaSeleccionMultiple,
        getPreguntasVerdaderoFalso:getPreguntasVerdaderoFalso,
        getPereguntasRellenar:getPereguntasRellenar
        
        
    };
})();
seg=15;
var numero=null;
var pregunta=(function Pregunta(){
    var numero=null; 
    function getNumero(){
        numero = Math.round(Math.random()*3);
        alert("Número aleatorio es:"+ numero);
        
    }
    function selectQUestion(){
        
        pregunta.getNumero();
        alert("QUe numero es:"+ numero);
        if(numero==1){
            information.getPreguntaSeleccionMultiple();
            
        }else if(numero==2){
            information.getPereguntasRellenar();
            
        }else if(numero==3){
            information.getPreguntasVerdaderoFalso();
        }else{
            information.getPreguntaSeleccionMultiple();
        }
    }
    function hacer(){
        pregunta.selectQUestion();
        pregunta.hora();

    }

    
    function hora(){
        
        int =setInterval(function(){
            seg--;
            document.getElementById('i').innerHTML=seg;
            if(seg==0){
                seg=15;
                alert("Se acabo el tiempo");
                pregunta.selectQUestion();
                
            }   
            
        },1000);
        seg++;
    }
    
    return {
        getNumero:getNumero,
        selectQUestion:selectQUestion,
        hora:hora,
        hacer:hacer
    };    
    })();



