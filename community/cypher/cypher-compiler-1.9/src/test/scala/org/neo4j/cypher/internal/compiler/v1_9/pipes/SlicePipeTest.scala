/**
 * Copyright (c) 2002-2013 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.cypher.internal.compiler.v1_9.pipes

import org.junit.Test
import org.scalatest.Assertions
import org.neo4j.cypher.internal.compiler.v1_9.ExecutionContext
import org.neo4j.cypher.internal.compiler.v1_9.commands.expressions.Literal

class SlicePipeTest extends Assertions {
  @Test
  def should_handle_longs() {
    //given
    val ctx = ExecutionContext.empty
    val input = new FakePipe(Iterator(ctx, ctx, ctx))
    val pipe = new SlicePipe(input, None, Some(Literal(42l)))

    //when
    val result = pipe.createResults(QueryState.empty).toList

    //then
    assert(result.size == 3)
  }
}