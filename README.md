# Preference Helper

Preference helper was created to help simplify the usage of shared preferences within dependency injection. With these classes you can quickly reference your shared preferences and use the getters and setters to create cleaner more readable code.
## Usage

Add this to your module dependencies:
```groovy
    compile 'com.nfx.android:preference-helper:0.0.2'
````

Create an object as follows
```java
StringPreference stringPref = StringPreference(getPreferenceManager().getSharedPreferences(), "key_string", "default_string");
````

Feed the constructor the shared preferences object you want to use, as well as the key and the default value.
This object can easily be injected when using a dependency injection library like dagger.

The following getters and setters are provided for manipulation and retrieval 
```java
    public T get();
    public void set(T value);
    public boolean isSet();
    public void delete();
    public String getKey();
````

## Versioning

[SemVer](http://semver.org/) is used for versioning. For the versions available, see the [tags on this repository](https://github.com/nfxdevelopment/range-bar-preferences/tags).

## Authors

* **Nicholas Winder** - *Initial Library* - [nfxdevelopment](https://github.com/nfxdevelopment)

## Licence
Licenced under *Apache2 licence*, so you can do whatever you want with it.
Please push back changes to help the library mature.
