

                package com.falace.basic;

                class Validator {

                    private boolean telephoneRequired = false;

                    boolean validate(User user) {
                        boolean valid = !user.getFirstName().isEmpty() &&
                                !user.getFirstName().isEmpty() &&
                                !user.getLastName().isEmpty();
                        if(telephoneRequired){
                            valid = valid && !user.getTelephone().isEmpty();
                        }
                        return valid;
                    }

                    public boolean isTelephoneRequired() {
                        return telephoneRequired;
                    }

                    public void setTelephoneRequired(boolean telephoneRequired) {
                        this.telephoneRequired = telephoneRequired;
                    }

                }






