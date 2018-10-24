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
package edu.eci.arsw.compscene.model.impl;

import edu.eci.arsw.compscene.model.Pregunta;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 *
 * @author dbeltran
 */
public class PreguntaRellenar extends Pregunta{
    
    private List<String> respuestaCorrecta;
    private Boolean  verdad=true;
    
    /**
     *Preguntas a Rellenar
     * 
     * <p>Use {@link #Sirve para almacenar las respuestas que son escritas por el usuario.*
     * 
     * @param respuestaCorrecta La respuesta correcta de la pregunta.  
     * @param id    El id de la pregunta.
     * @param enunciado El enunciado de la pregunta.
     * @param tema  El tema de la pregunta
     * @param opcionesDeRespuesta   Las respuestas del Usuario.
     * @param tiempo    El tiempo que se tomo el usuario en responder.
     */
    public PreguntaRellenar(List<String> respuestaCorrecta, int id, String enunciado, String tema, List<String> opcionesDeRespuesta, Timer tiempo) {
        super(id, enunciado, tema, opcionesDeRespuesta, tiempo);
        this.respuestaCorrecta = respuestaCorrecta;
    }

    /**
     *Validador de Respuesta
     * <p>Use {@link #.Valida la respuesta del usuario con las respuestas.* 
     * @param respuestaJugador  El arrreglo de respuestas del usuario.
     * @param respuestaCorrecta El arreglo de respuestas correctas.
     * @return Un Booleano con el valor true o false si el usuario se a equivocado.
     */
    @Override
    public boolean validadorRespuesta(Object respuestaJugador, Object respuestaCorrecta){
        ArrayList<String> respJugador=(ArrayList<String>) respuestaJugador;
        ArrayList<String> respCorr=(ArrayList<String>) respuestaCorrecta;
        int respcor=0;
        int a =0;
        int b=0;
        while(verdad && a<respJugador.size()&& b<respCorr.size()){
            if(respJugador.get(a).equals(respCorr.get(b))){
                a++;
                b++;  
                respcor++;
            }
            a++;
            b++;              
        }
        if(respcor>=respJugador.size()/2){
            verdad=true;
        }else{
            verdad=false;
        }
        return verdad; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *GetRespuestaJugador
     * <p>Use {@link #Sirve para devolver las respuestas que son escritas por el usuario.*
     * @return Una lista con las respuestas del usuario.
     */
    @Override
    public Object getRespuestaJugador() {
        return super.getRespuestaJugador(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *SetTeimpo
     * <p>Use {@link #Asigna un valor al tiempo del usuario..*
     * @param tiempo El tiempo del usuario en responder una pregunta.
     */
    @Override
    public void setTiempo(Timer tiempo) {
        super.setTiempo(tiempo); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *getTiempo
     * <p>Use {@link #Sirve para retornar el tiempo que el usuario a tomado para responder la pregunta*
     * 
     * @return El tiempo del usuario.
     */
    @Override
    public Timer getTiempo() {
        return super.getTiempo(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * <p>Use {@link #Sirve para almacenar las respuestas correctas de las preguntas.*
     * 
     * @param opcionesDeRespuesta  Asigna las respuestas correctas de las preguntas.
     */
    @Override
    public void setOpcionesDeRespuesta(List<String> opcionesDeRespuesta) {
        super.setOpcionesDeRespuesta(opcionesDeRespuesta); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *getOpciones de respuesta
     * <p>Use {@link #Sirve Devolver las respuestas correctas de las preguntas.*
     * @return Una lista de String con las opciones correctas de las preguntas.
     */
    @Override
    public List<String> getOpcionesDeRespuesta() {
        return super.getOpcionesDeRespuesta(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *setTema
     * <p>Use {@link #Establece un tema para una pregunta. *
     * @param tema El tema de la pregunta.
     */
    @Override
    public void setTema(String tema) {
        super.setTema(tema); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *getTema
     * <p>Use {@link #Regresa el tema de la pregunta.*
     * @return Un string con el tema de la pregunta.
     */
    @Override
    public String getTema() {
        return super.getTema(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *setEnunciado
     * <p>Use {@link #Sirve para almacenar el enunciado de la pregunta.* 
     * 
     * @param enunciado Es un string con el enunciado de la preguntado.
     */
    @Override
    public void setEnunciado(String enunciado) {
        super.setEnunciado(enunciado); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *getEnunciado
     * <p>Use {@link #Sirve para obtener el enunciado de la pregunta.*
     * 
     * @return Un string con el enunciado de la pregunta.
     */
    @Override
    public String getEnunciado() {
        return super.getEnunciado(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *setId
     * <p>Use {@link #.Sirve para establecer un id a la pregunta*
     * 
     * @param id Un entero que representa el identificador de la pregunta.
     */
    @Override
    public void setId(int id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *getId
     * <p>Use {@link #Sirve para regresar el identificador de la pregunta.*
     * @return un entero con el identificador de la pregunta.
     */
    @Override
    public int getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *getRespuestaCorrecta
     * <p>Use {@link # Regresa la lista de respuestas correctas.* 
     * 
     * @return Retorna una lista de String con la lista de respuesta correctas.
     */
    public List<String> getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    /**
     *setRespuestaCorrecta
     * <p>Use {@link #Sirve para almacenar las respuestas correctas del cuestionario. *
     * 
     * @param respuestaCorrecta Una lista con las respuestas correctas del cuestionario.
     */
    public void setRespuestaCorrecta(List<String> respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    
}
