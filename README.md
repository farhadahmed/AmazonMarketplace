# Amazon Marketplace Remake

This is a project for Ahmed Tech Academy students. Where I teach them how to build the back-end of Amazon Marketplace.

## Order of Tables
* Users
* Addresses
  * 1-to-1 relation with Users
* Products
  * Many-to-1 relation with Users that have a role of SELLER
* Orders
  * Many-to-1 relation with Users that have a role of BUYER
* OrderItems
  * Many-to-Many relation with Products and Orders