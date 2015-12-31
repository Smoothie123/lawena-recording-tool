# Lawena Contributing Guide

First of all, thanks for reading this! There are lots of ways you can help, and if you do it following these guidelines, it will be useful for everyone and I'll gladly help you, reciprocating your respect.

### Summary

If you need help or have questions, please use the [issue tracker](#issues). If you're [raising a bug](#bugs) please be sure to [include as much info as possible](#bug-template) so that can be fixed. If you've got some code you want to [pull request](#pull-requests) please ask first and together we'll find a way to make it work.

Currently the only one actively developing Lawena Recording Tool is **Quantic** ([github](https://github.com/iabarca)) ([steam](http://steamcommunity.com/profiles/76561198012092861/)). Montz is no longer developing the tool so only bother him to thank him for starting the project. If you want to help [in other ways](#get-involved), tell me about it via Steam or the [Gitter chat](https://gitter.im/iabarca/lawena-recording-tool).

<a name="get-involved"></a>
### Get involved

Tasks that need your help:

1. *Making sure Lawena does it's job* &mdash; Sometimes I mess up after an update. Please let me know! Also anything not working out correctly, I'm always listening.
2. *Contributing to the GitHub Wiki* &mdash; The [wiki](https://github.com/iabarca/lawena-recording-tool/wiki) is a great place to collect helpful information regarding the tool. You only require a GitHub account to edit the wiki so I will greatly appreciate all contributions.
3. *Porting Lawena to other games* &mdash; The tool can work out with most Source games with little modifications. If you are interested or want to suggest a game let me know.
4. *Helping with translations* &mdash; Contact me on [Steam](http://steamcommunity.com/profiles/76561198012092861/) for details.
5. *Increasing Linux/OSX support* &mdash; Lawena supports those operating systems but the truth is that they are far from optimal. I'm looking for help especially about supporting OSX.

<a name="issues"></a>
## Using the issue tracker

The [issue tracker](https://github.com/iabarca/lawena-recording-tool/issues) is
the preferred channel for [bug reports](#bugs), [feature requests](#features), [change requests](#changes) and [submitting pull requests](#pull-requests). I am always actively monitoring everything that happens there. That being said, I don't check forums too much.

<a name="bugs"></a>
## Bug reports

A bug is a _demonstrable problem_ that is caused by the code in the repository.
Good bug reports are extremely helpful - thank you!

Guidelines for bug reports:

1. **Use the GitHub issue search** &mdash; check if the issue has already been
   reported or even fixed to avoid duplicates. Don't forget searching [closed issues](https://github.com/iabarca/lawena-recording-tool/issues?q=is%3Aissue+is%3Aclosed).

2. **Include a screenshot or video if relevant** - Is your issue about a design or front end feature or bug? Use [LICEcap](http://www.cockos.com/licecap/) to quickly and easily record a short screencast (24fps) and save it as an animated gif! Embed it directly into your GitHub issue. If the issues happen while capturing frames, send me a YouTube link or the ``.dem`` file itself so we can test it together.

3. **Include as much info as possible!** Use the **Bug Report template** below or [click this link](https://github.com/iabarca/lawena-recording-tool/issues/new?title=Bug%3A&body=%23%23%23%20Issue%20Summary%0A%0A%23%23%23%20Steps%20to%20Reproduce%0A%0A1.%20This%20is%20the%20first%20step%0A%0AThis%20is%20a%20bug%20because...%0A%0A%23%23%23%20Technical%20details%0A%0A*%20Lawena%20Version%3A%20INSERT%20VERSION%20OR%20COMMIT%20REF%0A*%20Game%3A%20%0A*%20Your%20OS%3A%20%0A*%20Log%20file%3A%20) to start creating a bug report with the template automatically.

A good bug report shouldn't leave others needing to chase you up for more information. Please try to be as detailed as possible in your report. Any details will help people to fix any potential bugs.

<a name="bug-template"></a>
Template:
```
Short and descriptive example bug report title

### Issue Summary

A summary of the issue and the game/OS environment in which it occurs. If
suitable, include the steps required to reproduce the bug.

### Steps to Reproduce

1. This is the first step
2. This is the second step
3. Further steps, etc.

Any other information you want to share that is relevant to the issue being
reported. Especially, why do you consider this to be a bug? What do you expect to happen instead?

### Technical details:

* Lawena Version: 4.2.0-pre.2-34 (check Help menu -> About for this)
* Game: TF2
* Your OS: Windows 8.1 64 bit
* Log file: Pastebin link or just paste the relevant lines
```

<a name="features"></a>
### Feature Requests

I really like feature requests! Please use the issue tracker for this as well, stating that it's a feature request somewhere in there, after you do this:

1. Visit the [Roadmap](https://github.com/iabarca/lawena-recording-tool/wiki/Roadmap) & **use the GitHub search** to see if the feature has already been requested and then use the issue tracker to tell me about it.

2. Please provide as much detail and context as possible, this means explaining the use case and why it is likely to be common.

<a name="changes"></a>
### Change Requests

Change requests cover both architectural and functional changes to how Lawena works. If you have an idea for a new or different dependency, a refactor, or an improvement to a feature, etc - please be sure to:

1. **Use the GitHub search** and check someone else didn't get there first

2. Consider the following:
	- Is it really one idea or is it many?
	- What problem are you solving?
	- Why is what you are suggesting better than what's already there?

And then use the issue tracker again for this.

<a name="pull-requests"></a>
### Submitting Pull Requests

Pull requests (PR) are a really good feature to collaborate to the project directly with your code. For Lawena you can also create pull requests for changes to the included ``.cfg`` files, so you don't need to know how to program to help this way.

If you're looking to raise a PR for something which doesn't have an open issue, please think carefully about [raising an issue](#raising-issues) which your PR can close, especially if you're fixing a bug. This makes it more likely that there will be enough information available for your PR to be properly tested and merged. The project is small so just submit the pull request and we'll make it work together!

Use Steam for stuff not covered here. Issue tracker and Gitter chat for random questions also works.
