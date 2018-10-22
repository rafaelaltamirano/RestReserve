# Android Engineer Coding Challenge

## Introduction

Thank you for applying for the Android Engineer vacancy at Quandoo. In efforts to have an understanding of your skill level , we would like to proceed with an assessment that will give you a chance to show Quandoo that you are a battle proven Engineer!

## Task description
In this task we will kindly ask you to improve an existing codebase and make it readable , testable and maintainable up to modern standards. 

This repository is a starter project which is a fully functional android application. This project contains acceptance tests that cover some main features , but not all of them. We expect you to **add all missing acceptance tests along with some unit tests** that will ensure stability of your own code. 

Though provided project is complete in terms of functionality , it is in a very bad shape. We would expect you to **refactor the code base** and make it easy to read , navigate and test. We expect you to **change the architecture** .

## Application description

Provided application is a simplified version of a restaurant table management app that waiters use. Waiter opens the app and sees all the tables in the restaurant , some of the tables are reserved by customers and others are free. Waiter can click on reserved table and unreserve it , or he can click a free table and a customers screen will appear. Waiter can select only one of the customers that will reserve the previously clicked table.

## Data Flow
By default application will download data from fake server endpoints :
  - https://s3-eu-west-1.amazonaws.com/quandoo-assessment/customers.json
  - https://s3-eu-west-1.amazonaws.com/quandoo-assessment/reservations.json
  - https://s3-eu-west-1.amazonaws.com/quandoo-assessment/tables.json

Once data is downloaded , application will continue working with the data in an offline mode , by heavily relying on caching and local storage.

## Administrative instructions

Main brunch of this project is protected and you cannot modify it.

  - Please fork this project into a private GitLab repository.
  - Create a new branch from **master**.
  - Refactor the code gradually by submitting new descriptive commits (we will look into your commit messages).
  - We expect to see missing instrumentation tests along with unit tests.
  - Send us a link to the repository, together with private ssh key that allows access (settings > repository > deploy keys).
  - Submit the link to your private repository along with an ssh key to this email : assessment.submittal@quandoo.com
  - Please do not submit or post your solution anywhere else !



## Tech stack we want you to use
  - Retrofit
  - Dagger 2 
  - We would love you to use one of the following architectures 
    - Clean Architecture
    - MVVM
    - MVP
  - We welcome RxJava/RxKotlin

## Test scenarios
TBD