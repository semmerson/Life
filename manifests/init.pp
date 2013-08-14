group { "puppet":
  ensure => "present",
}

File { owner => 0, group => 0, mode => 0644 }

file { '/etc/motd':
  content => "Welcome to your Vagrant-built virtual machine!
              Managed by Puppet.\n"
}

Exec { path => ['/usr/bin', '/bin', '/usr/sbin', '/sbin'], }

exec {'bashrc':
  command => 'echo "set -o vi" >>/home/vagrant/.bashrc',
  unless  => 'grep "set *-o" /home/vagrant/.bashrc',
}
  
exec {'update': command => 'apt-get update', }

package {'openjdk-7-jdk':
  ensure  => present,
  require => Exec['update'],
}