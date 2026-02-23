package hexlet.code;

import picocli.CommandLine;

public final class  VersionProvider implements CommandLine.IVersionProvider  {
    @Override
    public String[] getVersion() throws Exception {
        return new String[]{"GenDiff v1.0"};
    }
}
