/**
 *Copyright (c) 2016 NewShweta
 *Project : TestLic(V1.0)
 */


package com.app.customexceptions;

import com.spartan.pluggable.exception.layers.ds.BusinessRulePreConditionException;


/**
 *Author : Shweta n zzz
 *Date :Thu Jun 09 12:38:43 UTC 2016
 */

public class InvalidName extends BusinessRulePreConditionException {


     private static final long serialVersionUID = 894802304419170048L;


     /** Create InvalidName with Alarm Id & Throwable.
      * @param _appAlarmId
      * @param _throwable
      */
     public InvalidName(final String _appAlarmId, Throwable _throwable) {
          super("InvalidName", _appAlarmId, _throwable);
     }

     /** Create InvalidName with Message, Alarm Id & Throwable.
      * @param _msg
      * @param _appAlarmId
      * @param _throwable
      */
     public InvalidName(final String _msg, final String _appAlarmId, final Throwable _throwable) {
          super(_msg, _appAlarmId, _throwable);
     }

     /** Create InvalidName with Message, Alarm Id, Throwable & Variable Arguments.
      * @param _msg
      * @param _appAlarmId
      * @param _throwable
      * @param _params
      */
     public InvalidName(final String _msg, final String _appAlarmId, final Throwable _throwable, final Object..._params) {
          super(_msg, _appAlarmId, _throwable, _params);
     }

}