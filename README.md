/apps/apache-maven-3.9.4/bin/mvn clean native:compile -Pnative -DskipTests


Error: Classes that should be initialized at run time got initialized during image building:
 io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess was unintentionally initialized at build time. To see why io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess got initialized use --trace-class-initialization=io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess
To see how the classes got initialized, use --trace-class-initialization=io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess

