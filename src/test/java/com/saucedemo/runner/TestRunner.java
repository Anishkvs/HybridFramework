package com.saucedemo.runner;

import org.testng.annotations.Listeners;

import com.listeners.CustomListeners;
import com.saucedemo.base.AutomationBase;

@Listeners(CustomListeners.class)

public class TestRunner extends AutomationBase {

}
