package lecture3;

import java.util.HashMap;

/**
 * Test to demonstrate use of equals, hashCode, use of Comparable<T>, and Comparator<T>
 * 
 * @author Lee
 *
 */
public class Test_HashCodeEqualsEx1 extends junit.framework.TestCase {

	/**
	 * Fail because we haven't implemented an equal/hashCode
	 */
	public void test1() {
		class ExampleClass {
			int _i;
			int _j;
			public ExampleClass( int i, int j ) {
				_i = i;
				_j = j;
			}
		}
		HashMap<ExampleClass,Integer> myHashMap = new HashMap<ExampleClass,Integer>();
		ExampleClass firstInstanceOfExampleClass = new ExampleClass( 5, 6 );
		ExampleClass secondInstanceOfExampleClass = new ExampleClass( 5, 6 );
		myHashMap.put( firstInstanceOfExampleClass, 59 );
		assertTrue( myHashMap.get( firstInstanceOfExampleClass ).equals(new Integer( 59 ) ) ); // Success!
		assertTrue( myHashMap.get( secondInstanceOfExampleClass ).equals(new Integer( 59 ) ) ); // Failure!
	}
	
	/**
	 * Fail with good equal but no hashCode
	 */
	public void test2() {
		class ExampleClass {
			int _i;
			int _j;
			public ExampleClass( int i, int j ) {
				_i = i;
				_j = j;
			}
			
			@Override
			public boolean equals( Object object ) { // Good equals
				if( ! ( object instanceof ExampleClass ) )
					return false;
				if( object == this )
					return true;
				ExampleClass zz = (ExampleClass) object;
				return ( _i == zz._i ) && ( _j == zz._j );
			}
			
			// No hashCode function
			
		}
		HashMap<ExampleClass,Integer> myHashMap = new HashMap<ExampleClass,Integer>();
		ExampleClass firstInstanceOfExampleClass = new ExampleClass( 5, 6 );
		ExampleClass secondInstanceOfExampleClass = new ExampleClass( 5, 6 );
		myHashMap.put( firstInstanceOfExampleClass, 59 );
		assertTrue( myHashMap.get( firstInstanceOfExampleClass ).equals(new Integer( 59 ) ) ); // Success!
		assertTrue( myHashMap.get( secondInstanceOfExampleClass ).equals(new Integer( 59 ) ) ); // Failure!
	}

	/**
	 * Fail with good hashCode but no equals
	 */
	public void test3() {
		class ExampleClass {
			int _i;
			int _j;
			public ExampleClass( int i, int j ) {
				_i = i;
				_j = j;
			}
			
			public int hashCode() { 
				int result = 17;
				result = 31 * result + _i;
				result = 31 * result + _j;
				return result;
			}
			
		}
		HashMap<ExampleClass,Integer> myHashMap = new HashMap<ExampleClass,Integer>();
		ExampleClass firstInstanceOfExampleClass = new ExampleClass( 5, 6 );
		ExampleClass secondInstanceOfExampleClass = new ExampleClass( 5, 6 );
		myHashMap.put( firstInstanceOfExampleClass, 59 );
		assertTrue( myHashMap.get( firstInstanceOfExampleClass ).equals(new Integer( 59 ) ) ); // Success!
		assertTrue( myHashMap.get( secondInstanceOfExampleClass ).equals(new Integer( 59 ) ) ); // Failure!
	}
	
	/**
	 * Pass with good equal/hashCode combo
	 */
	public void test4() {
		class ExampleClass {
			int _i;
			int _j;
			public ExampleClass( int i, int j ) {
				_i = i;
				_j = j;
			}
			
			public boolean equals( Object object ) { // Good equals
				if( ! ( object instanceof ExampleClass ) )
					return false;
				if( object == this )
					return true;
				ExampleClass zz = (ExampleClass) object;
				return ( _i == zz._i ) && ( _j == zz._j );
			}
			
			public int hashCode() { 
				int result = 17;
				result = 31 * result + _i;
				result = 31 * result + _j;
				return result;
			}
		}
		HashMap<ExampleClass,Integer> myHashMap = new HashMap<ExampleClass,Integer>();
		ExampleClass firstInstanceOfExampleClass = new ExampleClass( 5, 6 );
		ExampleClass secondInstanceOfExampleClass = new ExampleClass( 5, 6 );
		myHashMap.put( firstInstanceOfExampleClass, 59 );
		assertTrue( myHashMap.get( firstInstanceOfExampleClass ).equals(new Integer( 59 ) ) ); // Success!
		assertTrue( myHashMap.get( secondInstanceOfExampleClass ).equals(new Integer( 59 ) ) ); // Success!
	}

}
