package com.example.crudOper.Exception;

public class StudentNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String message) {
        super(message);
    }
}
