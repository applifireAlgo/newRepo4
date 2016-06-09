/**
 *Copyright (c) 2016 ShwetaS
 *Project : TestAOne(V1.0)
 */


package com.app.customexceptions;

import com.spartan.pluggable.exception.layers.ds.BusinessRulePreConditionException;


/**
 *Author : shweta n zagade
 *Date :Fri Jun 03 13:43:25 UTC 2016
 */

public class NameInvalid extends BusinessRulePreConditionException {


     private static final long serialVersionUID = 2918172979137987729L;


     /** Create NameInvalid with Alarm Id & Throwable.
      * @param _appAlarmId
      * @param _throwable
      */
     public NameInvalid(final String _appAlarmId, Throwable _throwable) {
          super("NameInvalid", _appAlarmId, _throwable);
     }

     /** Create NameInvalid with Message, Alarm Id & Throwable.
      * @param _msg
      * @param _appAlarmId
      * @param _throwable
      */
     public NameInvalid(final String _msg, final String _appAlarmId, final Throwable _throwable) {
          super(_msg, _appAlarmId, _throwable);
     }

     /** Create NameInvalid with Message, Alarm Id, Throwable & Variable Arguments.
      * @param _msg
      * @param _appAlarmId
      * @param _throwable
      * @param _params
      */
     public NameInvalid(final String _msg, final String _appAlarmId, final Throwable _throwable, final Object..._params) {
          super(_msg, _appAlarmId, _throwable, _params);
     }

}