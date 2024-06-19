package com.example.Student.Dto;

import java.util.List;

import lombok.Data;

@Data
public class DtoPageStudent<T> {
	
private List<T> content;

private int pageSize;

private int totalElements;

private int totalPage;

private Boolean last;

}
