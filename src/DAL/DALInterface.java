/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.ArrayList;

/**
 *
 * @author Hung
<<<<<<< HEAD
 * @param <T>
=======
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
 */
public interface DALInterface<T> {
    public boolean insert(T t);
    
    public boolean update(T t);
    
    public boolean delete(String id);
    
<<<<<<< HEAD
    public boolean delete(int id);
    
=======
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
    public ArrayList<T> getAll();
    
    public T getById(String id);
    
<<<<<<< HEAD
    public T getById(int id);
    
=======
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
    public ArrayList<T> getByCondition(String condition);
}
