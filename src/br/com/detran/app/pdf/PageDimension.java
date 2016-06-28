/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.detran.app.pdf;

/**
 *
 * @author PedroLima
 */
public interface PageDimension {
    public float getRealWidth(float ptWidth);
    public float getRealHeight(float ptHeight);
}
