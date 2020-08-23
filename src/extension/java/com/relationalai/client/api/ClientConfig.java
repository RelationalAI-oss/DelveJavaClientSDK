package com.relationalai.client.api;

import com.google.crypto.tink.KeysetHandle;
import com.relationalai.infra.config.InfraMetadataConfig;
import com.relationalai.util.auth.ClientSideAuthenticationUtil;
import org.ini4j.Ini;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ClientConfig
{
    File _configDir;
    InfraMetadataConfig.RaiRegion _region;
    String _accessKey;
    KeysetHandle _privateKeysetHandle;

    InfraMetadataConfig.Infra _infra = InfraMetadataConfig.Infra.AWS;
    String _raiHost = AWS_DEFAULT_HOST;
    int _raiPort = 443;

    public static final String AWS_DEFAULT_HOST = "aws.relationalai.com";
    public static final String AZURE_DEFAULT_HOST = "azure.relationalai.com";

    public static final String CONFIG_FILE_NAME = "rai_config";
    public static final String RAI_ACCESS_KEY = "rai_access_key";
    public static final String RAI_PRIVATE_KEY = "rai_private_key";
    public static final String RAI_INFRA = "rai_infra";
    public static final String RAI_HOST = "rai_host";
    public static final String RAI_PORT = "rai_port";
    public static final String REGION = "region";
    public static final String DEFAULT_PROFILE_NAME = "default";

    public static ClientConfig loadConfig(File configDir, String profileName) throws Exception
    {
        if ( !configDir.isDirectory() )
        {
            throw new Exception(configDir + " is not a directory");
        }

        File raiConfigFile = new File(configDir, CONFIG_FILE_NAME);
        if ( !raiConfigFile.exists() )
        {
            return new ClientConfig(configDir, InfraMetadataConfig.DEFAULT_REGION, null, null, null, null, null);
        }
        else
        {
            Ini ini = new Ini();
            ini.load(new FileReader(raiConfigFile));

            Ini.Section section = ini.get(profileName);
            if ( section != null )
            {
                String regionName = section.get(REGION);
                InfraMetadataConfig.RaiRegion region =
                    InfraMetadataConfig.RaiRegion.fromName(regionName);

                // rai infra host / port
                String infra = section.get(RAI_INFRA);
                String infraHost = section.get(RAI_HOST);
                String infraPortStr = section.get(RAI_PORT);

                // Load key if exists
                String accessKey = section.get(RAI_ACCESS_KEY);
                String privateKeyFilename = section.get(RAI_PRIVATE_KEY);

                if ( accessKey != null && privateKeyFilename != null )
                {
                    // private key file is in the configDir
                    File privateKeyFile = new File(configDir, privateKeyFilename);
                    KeysetHandle privateKeysetHandle =
                        privateKeyFile.exists() ? ClientSideAuthenticationUtil.getKeysetHandle(privateKeyFile) : null;

                    return new ClientConfig(configDir, region,
                        accessKey, privateKeysetHandle,
                        infra, infraHost, infraPortStr);
                }
                else
                {
                    return new ClientConfig(configDir, region,
                        null, null,
                        infra, infraHost, infraPortStr);
                }
            }
            else
            {
                return new ClientConfig(configDir,
                                        InfraMetadataConfig.DEFAULT_REGION,
                                        null, null, null, null, null);
            }
        }
    }

    public static File getConfigDir(File configDir)
    {
        if ( configDir == null )
        {
            return getDefaultConfigDir();
        }

        return configDir;
    }

    public static File getDefaultConfigDir()
    {
        String path = System.getProperty("user.home") + File.separator + ".rai";
        File raiConfigDir = new File(path);

        if ( !raiConfigDir.exists())
        {
            raiConfigDir.mkdirs();
        }

        return raiConfigDir;
    }

    public static File getConfigFile(File configDir) throws IOException
    {
        if ( configDir == null)
            configDir = getDefaultConfigDir();

        File configFile = new File(configDir, ClientConfig.CONFIG_FILE_NAME);

        // Check that the file exists. If not create stub
        if ( !configFile.exists())
        {
            configFile.createNewFile();
        }

        return configFile;
    }

    public ClientConfig(File configDir, InfraMetadataConfig.RaiRegion region,
        String accessKey, KeysetHandle privateKeysetHandle,
        String infra, String infraHost, String infraPortStr)
    {
        this._configDir = configDir;
        this._region = region;
        this._accessKey = accessKey;
        this._privateKeysetHandle = privateKeysetHandle;

        if ( infra != null && infra.trim().length() > 0 )
        {
            this._infra = InfraMetadataConfig.Infra.valueOf(infra.trim());
        }

        setHost(infraHost);
        setPort(infraPortStr);
    }

    private void setHost(String infraHost)
    {
        if ( infraHost != null && infraHost.trim().length() > 0)
        {
            this._raiHost = infraHost.trim();
        }
        else
        {
            this._raiHost = getDefaultHost(this._infra);
        }
    }

    private void setPort(String infraPortStr)
    {
        if ( infraPortStr != null && infraPortStr.trim().length() > 0 )
        {
            this._raiPort = Integer.parseInt(infraPortStr.trim());
        }
        else
        {
            this._raiPort = 443;
        }
    }

    private String getDefaultHost(InfraMetadataConfig.Infra infra)
    {
        if ( infra == InfraMetadataConfig.Infra.AWS )
        {
            return AWS_DEFAULT_HOST;
        }
        else
        {
            return AZURE_DEFAULT_HOST;
        }
    }

    public String getAccessKey()
    {
        return _accessKey;
    }

    public String getRegionName()
    {
        return _region.getName();
    }

    public KeysetHandle getPrivateKeysetHandle()
    {
        return _privateKeysetHandle;
    }

    public String getRaiHost()
    {
        return this._raiHost;
    }

    public int getRaiPort()
    {
        return this._raiPort;
    }
}
