package com.training.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class DemoB {

	@Autowired
	DemoA demoa;
}
