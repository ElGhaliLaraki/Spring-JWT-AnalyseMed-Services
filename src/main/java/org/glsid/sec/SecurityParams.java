package org.glsid.sec;

public interface SecurityParams {
    public static final String JWT_HEADER="Authorization";
    public static final String SECRET="ghalilaaraki@gmail.com";
    public static final long EXPIRATION=10*24*3600;
    public static final String HEADER_PREFIX="Bearer ";
}
