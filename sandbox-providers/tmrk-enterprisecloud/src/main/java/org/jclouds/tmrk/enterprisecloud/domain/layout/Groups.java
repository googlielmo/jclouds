/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.tmrk.enterprisecloud.domain.layout;

import com.google.common.collect.Sets;

import javax.xml.bind.annotation.XmlElement;
import java.util.Collections;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Wraps individual LayoutGroup elements.
 * <xs:complexType name="GroupsType">
 * @author Jason King
 */
public class Groups {

   @SuppressWarnings("unchecked")
   public static Builder builder() {
      return new Builder();
   }

   public Builder toBuilder() {
      return new Builder().fromGroups(this);
   }

   public static class Builder {

       private Set<LayoutGroup> groups = Sets.newLinkedHashSet();

       /**
        * @see Groups#getGroups
        */
       public Builder groups(Set<LayoutGroup> groups) {
          this.groups = Sets.newLinkedHashSet(checkNotNull(groups, "groups"));
          return this;
       }

       public Builder addGroup(LayoutGroup group) {
          groups.add(checkNotNull(group, "group"));
          return this;
       }

       public Groups build() {
           return new Groups(groups);
       }

       public Builder fromGroups(Groups in) {
         return groups(in.getGroups());
       }
   }

   private Groups() {
      //For JAXB and builder use
   }

   private Groups(Set<LayoutGroup> entries) {
      this.groups = Sets.newLinkedHashSet(entries);
   }

   @XmlElement(name = "Group", required=false)
   private Set<LayoutGroup> groups = Sets.newLinkedHashSet();

   public Set<LayoutGroup> getGroups() {
      return Collections.unmodifiableSet(groups);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Groups tasks1 = (Groups) o;

      if (!groups.equals(tasks1.groups)) return false;

      return true;
   }

   @Override
   public int hashCode() {
      return groups.hashCode();
   }

   public String toString() {
      return "["+ groups.toString()+"]";
   }
}
