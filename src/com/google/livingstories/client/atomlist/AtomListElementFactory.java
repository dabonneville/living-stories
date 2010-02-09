/**
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS-IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.livingstories.client.atomlist;

import com.google.livingstories.client.AtomType;
import com.google.livingstories.client.BaseAtom;

import java.util.Map;

/**
 * Static method to create an {@link AtomListElement} object for an atom, depending on its type.
 */
public class AtomListElementFactory {
  
  /**
   * Create an {@link AtomListElement} object for an atom, depending on its type.
   * @param atom atom to create the AtomList element for
   * @param idToAtomMap Map from atom ids to the atom objects that should contain entries for 
   * at least the atoms linked from the atom passed in the first parameter, but
   * can contain more. If the map is null, empty or doesn't contain the linked atoms, the complex
   * atoms will be displayed in a degenerate form without their linked atoms.
   * @param handler Handler that handles onClick events on the atoms in the atom list. Can be null
   * if no onclick behavior is needed.
   */
  public static AtomListElement createAtomListElement(BaseAtom atom, 
      Map<Long, BaseAtom> idToAtomMap, AtomClickHandler handler, boolean noHistoryOnToggle) {
    if (atom.getAtomType() == AtomType.EVENT) {
      return new EventAtomListElement(atom, idToAtomMap, noHistoryOnToggle);
    } else if (atom.getAtomType() == AtomType.NARRATIVE) {
      return new NarrativeAtomListElement(atom, idToAtomMap, noHistoryOnToggle);
    } else {
      return new SimpleAtomListElement(atom, handler);
    }
  }
}