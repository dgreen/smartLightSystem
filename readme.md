# Smart Light System

This was a UAB EE333 P5 assignment for Spring 2019 where P4 was the Object-Oriented design.  

## Purpose

The purpose of this project is to produce an **Object-Oriented Design** and
demonstration **Java program** that simulates a smart light system with a controller, hub and smart light bulbs.

## Overview

The goal of this project is to demonstrate your ability to do **object-oriented
design** and then implement a demonstration of the quality of **that design**.
The discussion that follows supplies *some* input necessary to create the object model but more discovery is likely necessary.

Figure 1 shows the conceptual block diagram for the lighting system.

![Figure 1.  Conceptual Block Diagram of light system](ControllerHubLights.svg)

## Discussion

The system shall consist of a controller, hub and multiple smart light bulbs.  The controller talks to the hub (bridge) which talks to the light bulbs. The lights shall have addressing to allow the control of lights.  The modules are connected in a broadcast manner where all modules hear all the messages and addressing is used to determine the parties of the conversation.

The simulation should be such that the simulated controller could be reimplemented to talk to a real hub and lights system without changing the architecture.  The controller is where there is an opportunity for near endless capabilities including **configuration**, **turning on/off bulbs**, **setting bulb color**, **setting bulb brightness**, defining bulbs in groups and manipulating same, defining moods to apply to bulbs or groups, doing actions on a time-basis, doing actions on an event basis, and having a sequence of activities. The **bold** items are considered the target for a base implementation of the simulation.   

There are several implementations of hubs and smart lights on the market.  The [Phillips product architecture][PhillipsArch] is one example.

[PhillipsArch]: https://www2.meethue.com/en-us/how-it-works

