



                    package com.falace.basic;



                    class Formatter {

                        User format(User user){
                            User formattedUser = new User();
                            formattedUser.setTelephone(user.getTelephone());

                            formattedUser.setEmail(user.getEmail().toLowerCase());
                            formattedUser.setFirstName(user.getFirstName().toLowerCase());
                            formattedUser.setLastName(user.getLastName().toLowerCase());

                            return formattedUser;
                        }

                    }




