/*
  *
  *  *  Copyright 2014 Orient Technologies LTD (info(at)orientechnologies.com)
  *  *
  *  *  Licensed under the Apache License, Version 2.0 (the "License");
  *  *  you may not use this file except in compliance with the License.
  *  *  You may obtain a copy of the License at
  *  *
  *  *       http://www.apache.org/licenses/LICENSE-2.0
  *  *
  *  *  Unless required by applicable law or agreed to in writing, software
  *  *  distributed under the License is distributed on an "AS IS" BASIS,
  *  *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  *  *  See the License for the specific language governing permissions and
  *  *  limitations under the License.
  *  *
  *  * For more information: http://www.orientechnologies.com
  *
  */
package com.orientechnologies.orient.core.hook;

import com.orientechnologies.orient.core.record.ORecord;

/**
 * Hook abstract class that calls separate methods for each hook defined.
 * 
 * @author Luca Garulli
 * @see ORecordHook
 */
public abstract class ORecordHookAbstract implements ORecordHook {

  /**
   * Called on unregistration.
   */
  public void onUnregister() {
  }

  /**
   * It's called just before to create the new iRecord.
   * 
   * @param iiRecord
   *          The iRecord to create
   * @return True if the iRecord has been modified and a new marshalling is required, otherwise false
   */
  public RESULT onRecordBeforeCreate(final ORecord iiRecord) {
    return RESULT.RECORD_NOT_CHANGED;
  }

  /**
   * It's called just after the iRecord is created.
   * 
   * @param iiRecord
   *          The iRecord just created
   */
  public void onRecordAfterCreate(final ORecord iiRecord) {
  }

  public void onRecordCreateFailed(final ORecord iiRecord) {
  }

  public void onRecordCreateReplicated(final ORecord iiRecord) {
  }

  /**
   * It's called just before to read the iRecord.
   * 
   * @param iRecord
   *          The iRecord to read
   * @return
   */
  public RESULT onRecordBeforeRead(final ORecord iRecord) {
    return RESULT.RECORD_NOT_CHANGED;
  }

  /**
   * It's called just after the iRecord is read.
   * 
   * @param iiRecord
   *          The iRecord just read
   */
  public void onRecordAfterRead(final ORecord iiRecord) {
  }

  public void onRecordReadFailed(final ORecord iiRecord) {
  }

  public void onRecordReadReplicated(final ORecord iiRecord) {
  }

  /**
   * It's called just before to update the iRecord.
   * 
   * @param iiRecord
   *          The iRecord to update
   * @return True if the iRecord has been modified and a new marshalling is required, otherwise false
   */
  public RESULT onRecordBeforeUpdate(final ORecord iiRecord) {
    return RESULT.RECORD_NOT_CHANGED;
  }

  /**
   * It's called just after the iRecord is updated.
   * 
   * @param iiRecord
   *          The iRecord just updated
   */
  public void onRecordAfterUpdate(final ORecord iiRecord) {
  }

  public void onRecordUpdateFailed(final ORecord iiRecord) {
  }

  public void onRecordUpdateReplicated(final ORecord iiRecord) {
  }

  /**
   * It's called just before to delete the iRecord.
   * 
   * @param iiRecord
   *          The iRecord to delete
   * @return True if the iRecord has been modified and a new marshalling is required, otherwise false
   */
  public RESULT onRecordBeforeDelete(final ORecord iiRecord) {
    return RESULT.RECORD_NOT_CHANGED;
  }

  /**
   * It's called just after the iRecord is deleted.
   * 
   * @param iiRecord
   *          The iRecord just deleted
   */
  public void onRecordAfterDelete(final ORecord iiRecord) {
  }

  public void onRecordDeleteFailed(final ORecord iiRecord) {
  }

  public void onRecordDeleteReplicated(final ORecord iiRecord) {
  }

  public RESULT onRecordBeforeReplicaAdd(final ORecord record) {
    return RESULT.RECORD_NOT_CHANGED;
  }

  public void onRecordAfterReplicaAdd(final ORecord record) {
  }

  public void onRecordReplicaAddFailed(final ORecord record) {
  }

  public RESULT onRecordBeforeReplicaUpdate(final ORecord record) {
    return RESULT.RECORD_NOT_CHANGED;
  }

  public void onRecordAfterReplicaUpdate(final ORecord record) {
  }

  public void onRecordReplicaUpdateFailed(final ORecord record) {
  }

  public RESULT onRecordBeforeReplicaDelete(final ORecord record) {
    return RESULT.RECORD_NOT_CHANGED;
  }

  public void onRecordAfterReplicaDelete(final ORecord record) {
  }

  public void onRecordReplicaDeleteFailed(final ORecord record) {
  }

  public RESULT onTrigger(final TYPE iType, final ORecord iRecord) {
    switch (iType) {
    case BEFORE_CREATE:
      return onRecordBeforeCreate(iRecord);

    case AFTER_CREATE:
      onRecordAfterCreate(iRecord);
      break;

    case CREATE_FAILED:
      onRecordCreateFailed(iRecord);
      break;

    case CREATE_REPLICATED:
      onRecordCreateReplicated(iRecord);
      break;

    case BEFORE_READ:
      return onRecordBeforeRead(iRecord);

    case AFTER_READ:
      onRecordAfterRead(iRecord);
      break;

    case READ_FAILED:
      onRecordReadFailed(iRecord);
      break;

    case READ_REPLICATED:
      onRecordReadReplicated(iRecord);
      break;

    case BEFORE_UPDATE:
      return onRecordBeforeUpdate(iRecord);

    case AFTER_UPDATE:
      onRecordAfterUpdate(iRecord);
      break;

    case UPDATE_FAILED:
      onRecordUpdateFailed(iRecord);
      break;

    case UPDATE_REPLICATED:
      onRecordUpdateReplicated(iRecord);
      break;

    case BEFORE_DELETE:
      return onRecordBeforeDelete(iRecord);

    case AFTER_DELETE:
      onRecordAfterDelete(iRecord);
      break;

    case DELETE_FAILED:
      onRecordDeleteFailed(iRecord);
      break;

    case DELETE_REPLICATED:
      onRecordDeleteReplicated(iRecord);
      break;

    }
    return RESULT.RECORD_NOT_CHANGED;
  }
}
